package com.hoangloc.weatherinformation;

import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.Locale;


public class FragmentWeather extends Fragment {
    TextView textViewCurrentLocation, textViewHumidity, textViewWindSpeed;
    TextView textViewCurrentTemperature, textViewTeperatureMinMax;
    TextView textViewUpdated, textViewWarning, textViewWeatherStatus;
    ImageView imageViewHumidity, imageViewMinMaxTemperature, imageViewWindSpeed, imageViewWeatherStatus;
    RecyclerView recyclerViewForecastHour;
    RecyclerView recyclerViewForecastDay;
    AdapterRCVForecastHour adapterRCVForecastHour;
    AdapterRCVForecastDay adapterRCVForecastDay;
    ConstraintLayout consLay;
    int currentTheme = 0;

    public FragmentWeather() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






        updateWeatherData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView =  inflater.inflate(R.layout.fragment_weather, container, false);
        textViewCurrentLocation =  myView.findViewById(R.id.textViewLocation);
        textViewCurrentTemperature = myView.findViewById(R.id.textViewTemperature);
        textViewTeperatureMinMax = myView.findViewById(R.id.textViewTemperatureMinMax);
        textViewHumidity =  myView.findViewById(R.id.textViewRain);
        textViewWindSpeed = myView.findViewById(R.id.textViewWindSpeed);
        textViewWarning =  myView.findViewById(R.id.textViewWarnings);
        textViewWeatherStatus =  myView.findViewById(R.id.textViewWeatherStatus);
        textViewUpdated =  myView.findViewById(R.id.textViewUpdated);
        recyclerViewForecastHour = myView.findViewById(R.id.recyclerViewForecastHour);
        recyclerViewForecastDay = myView.findViewById(R.id.recyclerViewForecastDay);
        consLay = myView.findViewById(R.id.constraintLayoutBackground);

        adapterRCVForecastHour = new AdapterRCVForecastHour();
        recyclerViewForecastHour.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewForecastHour.setAdapter(adapterRCVForecastHour);

        adapterRCVForecastDay = new AdapterRCVForecastDay();
        recyclerViewForecastDay.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewForecastDay.setAdapter(adapterRCVForecastDay);

        return myView;
    }

    void updateWeatherData(){
        new Thread(){
            Handler handler = new Handler();
            public void run(){
                final JSONObject json = DataFetcher.getJSON(getActivity(), "Sydney, AU");

                if (json == null){
                    handler.post(new Runnable(){
                        public void run(){
                            Toast.makeText(getActivity(), "Unable To Connect To Server" , Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else {
                    handler.post(new Runnable(){
                        public void run(){
                            //Toast.makeText(getActivity(), json.toString() , Toast.LENGTH_LONG).show();
                            WeatherInformationPacket WIP = renderWeatherInformation(json);
                            //textViewCurrentLocation.setText(WIP.weatherDescription);
                            setDataForTextView(WIP);
                        }
                    });
                }
            }
        }.start();
    }

    private WeatherInformationPacket renderWeatherInformation(JSONObject json){
        WeatherInformationPacket WIP = new WeatherInformationPacket();
        try {
            JSONObject coord = json.getJSONObject("coord");
            JSONObject weather = json.getJSONArray("weather").getJSONObject(0);
            JSONObject main = json.getJSONObject("main");
            JSONObject wind = json.getJSONObject("wind");
            JSONObject cloud = json.getJSONObject("clouds");
            //JSONObject rain = json.getJSONObject("rain");
            JSONObject sys = json.getJSONObject("sys");

            WIP.cityName = json.getString("name").toUpperCase(Locale.US) + ", "+ sys.getString("country");
            WIP.cityID = json.getString("id");
            WIP.longitude = coord.getLong("lon");
            WIP.latitude = coord.getLong("lat");
            WIP.weatherDescription = weather.getString("description");
            WIP.currentTemperature = main.getDouble("temp");
            WIP.maxTemperature = main.getDouble("temp_max");
            WIP.minTemperature = main.getDouble("temp_min");
            WIP.humidity = main.getDouble("humidity");
            WIP.windSpeed = wind.getDouble("speed");
            WIP.windDirection = wind.getString("deg");
            WIP.cloudiness = cloud.getDouble("all");
            //WIP.rainVolume = rain.getDouble("3h");
            WIP.sunriseTime = sys.getLong("sunrise");
            WIP.sunsetTime = sys.getLong("sunset");
            WIP.lastUpdatedTime = json.getLong("dt");
        }
        catch(Exception e){
            Log.e("Weather Information App", "One or more fields not found in the JSON data");
        }
        return WIP;
    }

    void setDataForTextView(WeatherInformationPacket WIP){
        textViewCurrentLocation.setText(WIP.cityName);
        textViewCurrentTemperature.setText(String.valueOf(WIP.currentTemperature).charAt(0) + "°C");
        textViewWeatherStatus.setText(WIP.weatherDescription);
        textViewHumidity.setText(String.valueOf(WIP.humidity) +" %");
        textViewWindSpeed.setText(String.valueOf(WIP.windSpeed) + " m/s");
        textViewTeperatureMinMax.setText(String.valueOf(WIP.minTemperature) + " - " + String.valueOf(WIP.maxTemperature));
        Toast.makeText(getActivity(), "Weather Information Has Been Updated" , Toast.LENGTH_LONG).show();
    }

    void setBackground(int i){
       if (i==0)
           consLay.setBackgroundResource(R.drawable.autumn);
       else consLay.setBackgroundResource(R.drawable.winter);
    }
}
