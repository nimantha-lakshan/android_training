package com.example.fidenz.alertspopups.sampledata;

public class Profile {
    private String img_url;
    private String profile_name;
    private String profile_details;

    public Profile(String img_url, String profile_name, String profile_details) {
        this.img_url = img_url;
        this.profile_name = profile_name;
        this.profile_details = profile_details;
    }

    public String getImgUrl() {
        return img_url;
    }

    public String getProfileName() {
        return profile_name;
    }

    public String getProfileDetail() {
        return profile_details;
    }
}
