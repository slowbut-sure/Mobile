package com.example.lap5;

public class Tech {
    private String name;
    private String brand;
    private int releaseYear;
    private double price;
    private int image;

    public Tech(String name, String brand, int releaseYear, double price, int image) {
        this.name = name;
        this.brand = brand;
        this.releaseYear = releaseYear;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}
