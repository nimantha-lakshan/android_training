package com.example.fidenz.api.model;

import com.google.gson.annotations.SerializedName;

public class Coordination {

    @SerializedName("lon")
    private double longitudes;
    @SerializedName("lat")
    private double latitude;

    public Coordination(double longitudes, double latitude) {
        this.longitudes = longitudes;
        this.latitude = latitude;
    }

    public double getLongitudes() {
        return longitudes;
    }

    public double getLatitude() {
        return latitude;
    }
}
