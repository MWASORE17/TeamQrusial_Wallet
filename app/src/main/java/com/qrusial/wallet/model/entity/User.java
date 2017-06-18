package com.qrusial.wallet.model.entity;

/**
 * Created by Agus Manto on 21/03/2017.
 */

import java.util.ArrayList;

public class User {
    private int id;
    private String email;
    private String password;

    public static int _id = 1;

    public static ArrayList<User> users = new ArrayList<>();

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.id = _id;
        _id++;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
