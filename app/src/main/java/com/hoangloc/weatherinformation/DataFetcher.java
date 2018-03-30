package com.hoangloc.weatherinformation;

/**
 * Created by NguyenHoangLoc on 3/28/2018.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class DataFetcher {

    private static final String OPEN_WEATHER_MAP_API =
            "http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric";

    public static JSONObject getJSON(Context context, String city){
        try {

            URL url = new URL("http://openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            //connection.addRequestProperty("x-api-key",context.getString(R.string.open_weather_maps_app_id));

            BufferedReader reader = new BufferedReader (new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp="";
            while((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(json.toString());



            // This value will be 404 if the request was not
            // successful
            if(data.getInt("cod") != 200){
                return null;
            }

            return data;
        }
        catch(Exception e){
            return null;
        }
    }

}