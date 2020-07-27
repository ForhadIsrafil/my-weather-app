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
    private String[] mobileArray;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context, String[] mobileArray) {
        this.context = context;
        this.mobileArray = mobileArray;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.weather_layout, viewGroup, false);

        return new MyViewHolder(view);
    }

    // - get element from your dataset at this position
    // - replace the contents of the view with that element
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.moboView.setText(mobileArray[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mobileArray.length;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView moboView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//            moboView = itemView.findViewById(R.id.mobo_id);
        }
    }
}
