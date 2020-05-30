package com.example.couchpotato.Classes;

public class Ingredient {
    private String name;
    private double price;
    private int amount;
    private  String unit;

    public Ingredient(String n, double p, int am,  String m) {
        name = n;
        price = p;
        amount = am;
        unit = m;
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
