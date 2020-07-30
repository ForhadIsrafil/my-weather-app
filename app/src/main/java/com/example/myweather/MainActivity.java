package com.example.myweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText countryName;
    Button submitButton;
    TextView response_data;
    ImageView image_view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryName = findViewById(R.id.countryName);
        submitButton = findViewById(R.id.submitButton);
        response_data = findViewById(R.id.response_id);
        image_view = findViewById(R.id.image_id);



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countryNameT = countryName.getText().toString().trim();
                if (TextUtils.isEmpty(countryNameT)) {
                    countryName.setError("Please Enter Country or City Name");
                    return;
                }

                // save data to table
//                CountryDatabase database = CountryDatabase.getDatabase(MainActivity.this);
//                Countries nameData = new Countries();
//                nameData.setName(countryNameT);
//                database.countriesDao.insertCountryName(nameData);

                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://api.openweathermap.org/data/2.5/weather?q=" + countryNameT + "&APPID=f7447d212a002af7623c1fb748233a6e";
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
                                    response_data.setText(data);
                                    Glide.with(MainActivity.this).load(icon_url).into(image_view);

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
                                response_data.setText(error_message);
                            }
                        });

                // Add the request to the RequestQueue.
                requestQueue.add(jsonObject_Request);
            }
        });
    }

    public void worldWeather(View view) {
        Intent to_weather = new Intent(this, CountriesWeatherActivity.class);
        startActivity(to_weather);
    }
}