package com.example.android.sunshine.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine.R;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {




    private String[] mWeatherData;


    public ForecastAdapter(){

    }


    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.forecast_list_item, viewGroup, false);
        return new ForecastAdapterViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int i) {

        holder.mWeatherTextView.setText(mWeatherData[i]);

    }

    @Override
    public int getItemCount() {

        if (mWeatherData == null) {
            return 0;
        } else {
            return mWeatherData.length;
        }


    }

    /**
     *
     *
     * Hava Durumu bilgilerinin adapter ' e aktarılmasını sağlayan metod.
     *
     *
     */
    public void setmWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }


    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {

        final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View itemView) {
            super(itemView);
            mWeatherTextView = itemView.findViewById(R.id.tv_weather_data);
        }
    }


}
