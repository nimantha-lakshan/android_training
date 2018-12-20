package com.example.fidenz.api.model;

import com.google.gson.annotations.SerializedName;

public class Clouds {
    @SerializedName("all")
    private double all;

    public Clouds(double all) {
        this.all = all;
    }

    public double getAll() {
        return all;
    }
}
