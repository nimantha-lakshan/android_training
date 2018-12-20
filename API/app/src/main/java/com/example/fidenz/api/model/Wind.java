package com.example.fidenz.api.model;

import com.google.gson.annotations.SerializedName;

public class Wind {
    @SerializedName("speed")
    private double speed;
    @SerializedName("deg")
    private double degrees;

    public Wind(double speed, double degrees) {
        this.speed = speed;
        this.degrees = degrees;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDegrees() {
        return degrees;
    }
}
