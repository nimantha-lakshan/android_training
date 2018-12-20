package com.example.fidenz.api.services.api;

import com.example.fidenz.api.model.OpenWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface APIInterface {

    @GET("2.5/weather?q=London&APPID=1f933d36cea11536a814beb9e6581be8")
    Call<OpenWeather> getWeather();
//    Call<OpenWeather> getWeather(@Path("city") String city);
}
