package com.example.couchpotato.Classes;

public class Food {
    private String name;
    private int timeStocked, expiration;

    public Food(String n, int t, int e) {
        name = n;
        timeStocked = t;
        expiration = e;
    }

    public String getName() {
        return name;
    }

    public int getTimeStocked() {
        return timeStocked;
    }

    public int getExpiration() {
        return expiration;
    }
}
