package com.example.couchpotato.Classes;

public class Ingredient {
    private String name, unit;
    private double price;
    private int amount, expiration;

    public Ingredient(String n, String u, double p, int am, int e) {
        name = n;
        unit = u;
        price = p;
        amount = am;
        expiration = e;
    }


    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public double getPrice() {
        return price;
    }
}
