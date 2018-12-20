package com.example.fidenz.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpenWeather {

    @SerializedName("coord")
    private Coordination coordination;

    @SerializedName("weather")
    private List<Weather> weather;

    @SerializedName("base")
    private String base;

    @SerializedName("main")
    private Main main;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("rain")
    private Rain rain;

    @SerializedName("clouds")
    private Clouds clouds;

    @SerializedName("snow")
    private Snow snow;

    @SerializedName("dt")
    private int utc;

    @SerializedName("sys")
    private Location location;

    @SerializedName("id")
    private int id_city;

    @SerializedName("name")
    private String name_city;

    @SerializedName("cod")
    private int cod;

    public OpenWeather(Coordination coordination, List<Weather> weather, String base, Main main, Wind wind, Rain rain, Clouds clouds, Snow snow, int utc, Location location, int id_city, String name_city, int cod) {
        this.coordination = coordination;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.wind = wind;
        this.rain = rain;
        this.clouds = clouds;
        this.snow = snow;
        this.utc = utc;
        this.location = location;
        this.id_city = id_city;
        this.name_city = name_city;
        this.cod = cod;
    }

    public Coordination getCoordination() {
        return coordination;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getM() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Rain getRain() {
        return rain;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Snow getSnow() {
        return snow;
    }

    public int getUtc() {
        return utc;
    }

    public Location getLocation() {
        return location;
    }

    public int getId_city() {
        return id_city;
    }

    public String getName_city() {
        return name_city;
    }

    public int getCod() {
        return cod;
    }
}
