package com.example.myweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CountriesWeatherActivity extends AppCompatActivity {
    TextView response_data;
    ImageView image_view;
    ListView country_list_view;
    // Array of strings...
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_weather);

        response_data = findViewById(R.id.response_id);
        image_view = findViewById(R.id.image_id);
//        country_list_view = findViewById(R.id.weather_list_id);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_countries_weather, mobileArray);
        country_list_view = findViewById(R.id.weather_list_id);
        country_list_view.setAdapter(adapter);
    }
}