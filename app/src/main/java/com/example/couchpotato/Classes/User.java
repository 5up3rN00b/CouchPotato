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
        cart = new ArrayList<>();
        stocked = new ArrayList<>();
        bought = new ArrayList<>();
        preferences = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void addToCart(Ingredient i) {
        cart.add(i);
    }

    public void buyCart() {
        for (int i = 0; i < cart.size(); i++) {
            Ingredient ingredient = cart.get(i);
            Food f = new Food(ingredient.getName(), System.currentTimeMillis(), 10);
        }
    }
}
