package com.example.fidenz.objectbox.database;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class User {

    @Id
    public long user_id;

    private String first_name;
    private String last_name;
    private int mobile;
    private String email;

    public User() {
    }

    public User(long user_id, String first_name, String last_name, int mobile, String email) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.mobile = mobile;
        this.email = email;
    }

    public long getUser_id() {
        return user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
