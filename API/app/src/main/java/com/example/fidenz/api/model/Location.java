package com.example.fidenz.api.model;

import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("type")
    private int type;
    @SerializedName("id")
    private int id;
    @SerializedName("message")
    private String message;
    @SerializedName("country")
    private String country;
    @SerializedName("sunrise")
    private int sunrise;
    @SerializedName("sunset")
    private int sunset;

    public Location(int type, int id, String message, String country, int sunrise, int sunset) {
        this.type = type;
        this.id = id;
        this.message = message;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public int getSunset() {
        return sunset;
    }
}
