package com.example.couchpotato.Classes;

public class Food {
    private String name;
    private int timeStocked, price;

    public Food(String n, int t, int p) {
        name = n;
        timeStocked = t;
        price = p;
    }

    public String getName() {
        return name;
    }

    public int getTimeStocked() {
        return timeStocked;
    }

    public int getPrice() {
        return price;
    }
}
