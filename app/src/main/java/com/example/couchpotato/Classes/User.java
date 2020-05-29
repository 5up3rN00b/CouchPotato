package com.example.couchpotato.Classes;

import java.util.ArrayList;

public class User {
    private String name;
    private int price;
    private ArrayList<Ingredient> cart;
    private ArrayList<Food> stocked, bought;
    private ArrayList<String> preferences;

    public User(String n, int p) {
        name = n;
        price = p;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
