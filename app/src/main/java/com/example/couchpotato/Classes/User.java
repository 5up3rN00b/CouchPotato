package com.example.couchpotato.Classes;

import java.util.ArrayList;

public class User {
    private String name, password;
    private int balance;
    private ArrayList<Ingredient> cart;
    private ArrayList<Food> stocked, bought;
    private ArrayList<String> preferences;

    public User(String n, String p, int b) {
        name = n;
        password = p;
        balance = b;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }
}
