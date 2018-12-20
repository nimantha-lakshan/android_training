package com.example.fidenz.api.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fidenz.api.R;
import com.example.fidenz.api.model.OpenWeather;
import com.example.fidenz.api.services.api.APIInterface;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_main_view)
    RelativeLayout view;

    @BindView(R.id.txt_city)
    TextView city;

    @BindView(R.id.txt_min_temperature)
    TextView min_temperature;

    @BindView(R.id.txt_temperature)
    TextView temperature;

    @BindView(R.id.txt_max_temperature)
    TextView max_temperature;

    @BindView(R.id.txt_weather_status)
    TextView weather_status;

    @BindView(R.id.txt_wind_speed)
    TextView wind_speed;

    @BindView(R.id.txt_clouds)
    TextView clouds;

    @BindView(R.id.txt_longitude)
    TextView longitude;

    @BindView(R.id.txt_latitude)
    TextView latitude;

    private DecimalFormat decimalFormat = new DecimalFormat("0.#");
    private OpenWeather openWeather;
    private double kelvin = 273.15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        Spinner select_city = findViewById(R.id.spinner_city);
//        select_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String city_name = parent.getItemAtPosition(position).toString();
//                setData(city_name);
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });

    }

    @OnItemSelected(R.id.spinner_city)
    public void onCitySelected(Spinner spinner, int position) {
        String city = spinner.getItemAtPosition(position).toString();
        setData(city);
    }

    private void setData(String city_name) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface apiInterface = retrofit.create(APIInterface.class);
        final Call<OpenWeather> weather = apiInterface.getWeather("2.5/weather?q=" + city_name + "&APPID=1f933d36cea11536a814beb9e6581be8");

        weather.enqueue(new Callback<OpenWeather>() {
            @Override
            public void onResponse(Call<OpenWeather> call, Response<OpenWeather> response) {
                if (response.isSuccessful()) {
                    openWeather = response.body();

                    city.setText(openWeather.getName_city());
                    min_temperature.setText(decimalFormat.format(openWeather.getM().getMin_temperature() - kelvin));
                    temperature.setText(decimalFormat.format(openWeather.getM().getTemperature() - kelvin));
                    max_temperature.setText(decimalFormat.format(openWeather.getM().getMax_temperature() - kelvin));
                    weather_status.setText(openWeather.getWeather().get(0).getDescription());
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
