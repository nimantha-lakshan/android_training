package com.example.fidenz.test;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {

    private String img_url;
    private String user_name;
    private String description;

    public Student(String img_url, String user_name, String description) {
        this.img_url = img_url;
        this.user_name = user_name;
        this.description = description;
    }


    protected Student(Parcel in) {
        img_url = in.readString();
        user_name = in.readString();
        description = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(img_url);
        dest.writeString(user_name);
        dest.writeString(description);
    }




    public String getImages() {
        return img_url;
    }

    public String getUserName() {
        return user_name;
    }

    public String getDescriptions() {
        return description;
    }
}
