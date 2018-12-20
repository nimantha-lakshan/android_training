package com.example.fidenz.api.model;

public class Weather {
    private int id;
    private String weather_status;
    private String description;
    private String icon_id;

    public Weather(int id, String weather_status, String description, String icon_id) {
        this.id = id;
        this.weather_status = weather_status;
        this.description = description;
        this.icon_id = icon_id;
    }

    public int getId() {
        return id;
    }

    public String getWeather_status() {
        return weather_status;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon_id() {
        return icon_id;
    }
}
