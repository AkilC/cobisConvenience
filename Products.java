package com.company;

public class Products {
    private String name;
    private double price;
    private int amount;

    public Products(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Products() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
