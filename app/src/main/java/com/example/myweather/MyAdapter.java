package com.example.myweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    String[] mobileArray;

    public MyAdapter(Context context, String[] mobileArray) {
        this.context = context;
        this.mobileArray = mobileArray;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.weather_layout, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.moboView.setText(mobileArray[position]);

    }

    @Override
    public int getItemCount() {
        return mobileArray.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView moboView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            moboView = itemView.findViewById(R.id.mobo_id);
        }
    }
}
