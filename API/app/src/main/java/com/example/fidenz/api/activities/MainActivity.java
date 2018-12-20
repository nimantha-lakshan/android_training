package com.example.fidenz.api.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fidenz.api.R;
import com.example.fidenz.api.model.OpenWeather;
import com.example.fidenz.api.services.api.APIInterface;


import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView city;
    private TextView min_temperature;
    private TextView temperature;
    private TextView max_temperature;
    private TextView weather_status;
    private TextView wind_speed;
    private TextView clouds;
    private TextView longitude;
    private TextView latitude;

    private DecimalFormat decimalFormat = new DecimalFormat("00");
    private OpenWeather openWeather;
    private double kelvin = 273.15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner select_city = findViewById(R.id.spinner_city);

        city = findViewById(R.id.txt_city);
        min_temperature = findViewById(R.id.txt_min_temperature);
        temperature = findViewById(R.id.txt_temperature);
        max_temperature = findViewById(R.id.txt_max_temperature);
        weather_status = findViewById(R.id.txt_weather_status);
        wind_speed = findViewById(R.id.txt_wind_speed);
        clouds = findViewById(R.id.txt_clouds);
        longitude = findViewById(R.id.txt_longitude);
        latitude = findViewById(R.id.txt_latitude);


        select_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String city_name = parent.getItemAtPosition(position).toString();
                setData(city_name);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    private void setData(String city_name) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface apiInterface = retrofit.create(APIInterface.class);
        final Call<OpenWeather> weather = apiInterface.getWeather();

        weather.enqueue(new Callback<OpenWeather>() {
            @Override
            public void onResponse(Call<OpenWeather> call, Response<OpenWeather> response) {
                if (response.isSuccessful()) {
                    openWeather = response.body();

                    city.setText(openWeather.getName_city());
                    min_temperature.setText(decimalFormat.format(openWeather.getM().getMin_temperature() - kelvin));
                    temperature.setText(decimalFormat.format(openWeather.getM().getTemperature() - kelvin));
                    max_temperature.setText(decimalFormat.format(openWeather.getM().getMax_temperature() - kelvin));
                    weather_status.setText(openWeather.getWeather().get(0).getWeather_status());
                    wind_speed.setText(String.valueOf(openWeather.getWind().getSpeed()));
                    clouds.setText(String.valueOf(openWeather.getClouds().getAll()));
                    longitude.setText(String.valueOf(openWeather.getCoordination().getLongitudes()));
                    latitude.setText(String.valueOf(openWeather.getCoordination().getLatitude()));

                }
            }

            @Override
            public void onFailure(Call<OpenWeather> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Connection Failed", Toast.LENGTH_LONG).show();
            }
        });

    }
}
