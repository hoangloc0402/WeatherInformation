package com.hoangloc.weatherinformation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterRCVForecastDay extends RecyclerView.Adapter<AdapterRCVForecastDay.RecyclerViewHolder>{

    //private List<String> data = new ArrayList<>();

    public AdapterRCVForecastDay(/*List<String> data*/) {
        //this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_forecast_day, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.textViewDaysOfWeek.setText("Wednesday");
        holder.textViewMinTemp.setText("10°C");
        holder.textViewMaxTemp.setText("20°C");
    }

    @Override
    public int getItemCount() {
        //return data.size();
        return 12;
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView textViewDaysOfWeek, textViewMinTemp, textViewMaxTemp;
        ImageView imageViewWeatherStatus;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            textViewDaysOfWeek =  itemView.findViewById(R.id.textViewDaysOfWeek);
            textViewMinTemp =  itemView.findViewById(R.id.textViewForecastMinTemp);
            textViewMaxTemp =  itemView.findViewById(R.id.textViewForecastMaxTemp);
            imageViewWeatherStatus =  itemView.findViewById(R.id.imageViewForecastWeatherStatus);
        }
    }
}
