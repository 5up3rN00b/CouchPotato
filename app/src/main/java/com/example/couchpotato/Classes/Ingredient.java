package com.example.couchpotato.Classes;

public class Ingredient {
    private String name, unit;
    private double price;
    private int amount, expiration;

    public Ingredient(String n, double p, int am, String u, int e) {
        name = n;
        unit = u;
        price = p;
        amount = am;
        expiration = e; // -1 if no expiration?
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

    public void increase(){
        amount++;
    }

    public void add (int am) {amount += am;}

    public void decrease(){
        if(!(amount == 0)){
            amount--;
        }
    }

    public void setAmount(int amount){
        this.amount = amount;
    }
}
