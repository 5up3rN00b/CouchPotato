package com.example.couchpotato.Classes;

public class Ingredient {
    private String name;
    private int price;

    public Ingredient(String n, int p) {
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
