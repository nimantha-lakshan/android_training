package com.example.fidenz.api.services.api;

import com.example.fidenz.api.model.OpenWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;


public interface APIInterface {

    @GET
    Call<OpenWeather> getWeather(@Url String url);
//    Call<OpenWeather> getWeather();
}
