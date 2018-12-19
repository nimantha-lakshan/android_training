package com.example.fidenz.usermanagement.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {

    @Id(autoincrement = true)
    private Long user_id;

    private String username;
    private int mobile;
    private String password;

    @Generated(hash = 1195222968)
    public User(Long user_id, String username, int mobile, String password) {
        this.user_id = user_id;
        this.username = username;
        this.mobile = mobile;
        this.password = password;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMobile() {
        return this.mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
