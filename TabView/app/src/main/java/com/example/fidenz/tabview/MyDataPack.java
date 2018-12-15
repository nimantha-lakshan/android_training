package com.example.fidenz.tabview;

public class MyDataPack {
    private String display_image;
    private String display_name;
    private String display_description;

    public MyDataPack(String display_image, String display_names, String display_description) {
        this.display_image = display_image;
        this.display_name = display_names;
        this.display_description = display_description;
    }

    public String getDisplayImages() {
        return display_image;
    }

    public String getDisplayNames() {
        return display_name;
    }

    public String getDescriptions() {
        return display_description;
    }
}
