package com.example.myweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CountriesWeatherActivity extends AppCompatActivity {
    //    TextView response_data;
//    ImageView image_view;
    MyAdapter myAdapter;
    // Array of strings...
    String[] countryArray = {"dhaka", "london"};

    List<String> response_data_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_weather);

//        response_data = findViewById(R.id.response_id);
//        image_view = findViewById(R.id.image_id);
        final RecyclerView recyclerView = findViewById(R.id.weather_list_id);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

//        myAdapter = new MyAdapter(this, mobileArray);
//        recyclerView.setAdapter(myAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Todo Here

        for (int i = 0; i <= countryArray.length; i++) {
            RequestQueue requestQueue = Volley.newRequestQueue(CountriesWeatherActivity.this);

            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + countryArray[i] + "&APPID=f7447d212a002af7623c1fb748233a6e";
            System.out.println("url........ " + url);

            // Formulate the request and handle the response.
            JsonObjectRequest jsonObject_Request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // Todo here
                            System.out.println("i am response " + response);
                            try {
                                JSONObject jsonObj = new JSONObject(response.toString());
                                JSONArray weather_data = jsonObj.getJSONArray("weather");
                                JSONObject weather_obj = weather_data.getJSONObject(0);
                                String weather_description = weather_obj.getString("description");
                                String temperature = jsonObj.getJSONObject("main").getString("temp");
                                float final_temperature = Float.parseFloat(temperature) - Float.parseFloat("273.15");
                                String wind = jsonObj.getJSONObject("wind").getString("speed");

                                String weather_icon = weather_obj.getString("icon");
                                String icon_url = "https://openweathermap.org/img/w/" + weather_icon + ".png";
                                System.out.println("i am response2 " + final_temperature);
                                String data = "Temperature: " + Math.round(final_temperature) + "°С\n Wind: " + wind + " Mile/S\n" + weather_description;
//                                response_data.setText(data);
//                                Glide.with(CountriesWeatherActivity.this).load(icon_url).into(image_view);
                                System.out.println("response_data_list empty " + response_data_list);

                                response_data_list.add(data);
                                System.out.println("response_data_list " + response_data_list);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Handle error
                            System.out.println("error....... " + error); // todo here
                            String error_message = "Country or City not found!";
//                            response_data.setText(error_message);
                        }
                    });

            // Add the request to the RequestQueue.
            requestQueue.add(jsonObject_Request);
        }
        WeatherAdapter weatherAdapter = new WeatherAdapter(CountriesWeatherActivity.this, (ArrayList<String>) response_data_list);
        recyclerView.setAdapter(weatherAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(CountriesWeatherActivity.this));

    }
}