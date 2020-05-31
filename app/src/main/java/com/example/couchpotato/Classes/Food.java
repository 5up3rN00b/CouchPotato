package com.example.couchpotato.Classes;

public class Food {
    private String name;
    private int expiration;
    private long timeStocked;

    public Food(String n, long t, int e) {
        name = n;
        timeStocked = t;
        expiration = e;
    }

    public String getName() {
        return name;
    }

    public long getTimeStocked() {
        return timeStocked;
    }

    public int getExpiration() {
        return expiration;
    }
}
