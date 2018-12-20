package com.example.fidenz.api.model;

import com.google.gson.annotations.SerializedName;

public class Snow {
    @SerializedName("1h")
    private double last_one_hour;
    @SerializedName("3h")
    private double last_three_hour;

    public Snow(double last_one_hour, double last_three_hour) {
        this.last_one_hour = last_one_hour;
        this.last_three_hour = last_three_hour;
    }

    public double getLast_one_hour() {
        return last_one_hour;
    }

    public double getLast_three_hour() {
        return last_three_hour;
    }
}
