package com.example.couchpotato.Classes;

import java.util.ArrayList;

public class Recipe {
    private ArrayList<Ingredient> recipe;
    private String name, preference;
    private double price;

    public Recipe(ArrayList<Ingredient> r, String n, String p, double price) {
        recipe = r;
        name = n;
        preference = p;
        this.price = price;
    }

    public ArrayList<Ingredient> getRecipe() {
        return recipe;
    }

    public String getName() {
        return name;
    }

    public String getPreference() {
        return preference;
    }

    public double getPrice() {
        return price;
    }
}
