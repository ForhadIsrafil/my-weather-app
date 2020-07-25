package com.example.myweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CountriesWeatherActivity extends AppCompatActivity {
    TextView response_data;
    ImageView image_view;
    MyAdapter myAdapter;
    // Array of strings...
    String[] mobileArray = {"Android", "IPhone", "WindowsMobile", "Blackberry",
            "WebOS", "Ubuntu", "Windows7", "Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_weather);

        response_data = findViewById(R.id.response_id);
        image_view = findViewById(R.id.image_id);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.weather_list_id);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MyAdapter(this, mobileArray);
        recyclerView.setAdapter(myAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}