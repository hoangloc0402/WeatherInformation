package com.hoangloc.weatherinformation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterRCVForecastHour extends RecyclerView.Adapter<AdapterRCVForecastHour.RecyclerViewHolder>{

    //private List<String> data = new ArrayList<>();

    public AdapterRCVForecastHour(/*List<String> data*/) {
        //this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_forecast_hour, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.textViewHour.setText("07:00 PM");
        holder.textViewDegree.setText("10°C");
    }

    @Override
    public int getItemCount() {
        //return data.size();
        return 20;
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView textViewHour, textViewDegree;
        ImageView imageViewWeatherStatus;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            textViewHour =  itemView.findViewById(R.id.textViewHour);
            textViewDegree =  itemView.findViewById(R.id.textViewDegree);
            imageViewWeatherStatus =  itemView.findViewById(R.id.imageViewForecastWeatherStatus);
        }
    }
}
