package com.company;

import java.util.ArrayList;

public class Customers {
    private String name;
    private double total;

    private ArrayList<Products> myproducts = new ArrayList<Products>();

    public Customers(String name) {
        this.name = name;
    }

    public Customers() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Products> getMyproducts() {
        return myproducts;
    }

    public void setMyproducts(ArrayList<Products> myproducts) {
        this.myproducts = myproducts;
    }

    public void addProducts(Products product) {
        myproducts.add(product);
    }
}
