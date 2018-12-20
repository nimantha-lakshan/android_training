package com.example.fidenz.api.model;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    private double temperature;
    @SerializedName("pressure")
    private double pressure;
    @SerializedName("humidity")
    private double humidity;
    @SerializedName("temp_min")
    private double min_temperature;
    @SerializedName("temp_max")
    private double max_temperature;
    @SerializedName("sea_level")
    private double sea_level;
    @SerializedName("grnd_level")
    private double ground_level;

    public Main(double temperature, double pressure, double humidity, double min_temperature, double max_temperature, double sea_level, double ground_level) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.min_temperature = min_temperature;
        this.max_temperature = max_temperature;
        this.sea_level = sea_level;
        this.ground_level = ground_level;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getMin_temperature() {
        return min_temperature;
    }

    public double getMax_temperature() {
        return max_temperature;
    }

    public double getSea_level() {
        return sea_level;
    }

    public double getGround_level() {
        return ground_level;
    }
}
