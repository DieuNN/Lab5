package com.example.lab5.Model;

public class Product {
    private String id;
    private String name;
    private double price;
    private int image;

    public Product() {
    }

    public Product(String name, String id, double price, int image) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
