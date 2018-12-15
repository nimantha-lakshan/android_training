package com.example.fidenz.test;

import java.io.Serializable;

public class Car implements Serializable {
    private String carModel;
    private String color;
    private String mfd;

    public Car(String carModel, String color, String mfd) {
        this.carModel = carModel;
        this.color = color;
        this.mfd = mfd;
    }

    public String getCarModel(){
        return carModel;
    }

    public String getCarColor(){
        return color;
    }

    public String getMfd(){
        return mfd;
    }
}
