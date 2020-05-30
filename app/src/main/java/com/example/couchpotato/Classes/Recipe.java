package com.example.couchpotato.Classes;

import java.util.ArrayList;

public class Recipe {
    private ArrayList<Ingredient> recipe;
    private String name, preference;

    public Recipe(ArrayList<Ingredient> r, String n, String p) {
        recipe = r;
        name = n;
        preference = p;
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
}
