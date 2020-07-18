package com.example.myweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CountriesWeatherActivity extends AppCompatActivity {
    TextView response_data;
    ImageView image_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_weather);

        response_data = findViewById(R.id.response_id);
        image_view = findViewById(R.id.image_id);
    }
}