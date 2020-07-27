package com.example.myweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherHolder> {
    Context context;
    private ArrayList<String> response_data_list;

    public WeatherAdapter(Context context, ArrayList<String> response_data_list) {
        this.context = context;
        this.response_data_list = response_data_list;
    }

    @NonNull
    @Override
    public WeatherHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.weather_layout, parent, false);
        return new WeatherHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherHolder holder, int position) {
        holder.response_data.setText(response_data_list.get(position));

    }

    @Override
    public int getItemCount() {
        return response_data_list.size();
    }

    public static class WeatherHolder extends RecyclerView.ViewHolder {
        TextView response_data;

        public WeatherHolder(@NonNull View itemView) {
            super(itemView);
            response_data = itemView.findViewById(R.id.response_id);
        }
    }
}
