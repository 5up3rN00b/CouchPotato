package com.example.couchpotato.Classes;

public class Ingredient {
    private String name;
    private double price;
    private String amount;

    public Ingredient(String n, double p, String m) {
        name = n;
        price = p;
        amount = m;
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }
}
