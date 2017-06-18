package com.qrusial.wallet.model.entity;

import java.util.ArrayList;

/**
 * Created by Agus Manto on 28/05/2017.
 */

public class Account {
    private int id;
    private String account;
    private String value;

    public static int _id = 1;

    public static ArrayList<Account> accounts = new ArrayList<>();

    public Account() {}

    public Account(String account, String value) {
        this.account = account;
        this.value = value;
        this.id = _id;
        _id++;
    }

    public int getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
