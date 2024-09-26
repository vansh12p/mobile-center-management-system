package com.mobilecenter.models;

public class Mobile {
    private String id;
    private String name;
    private String brand;
    private double price;
    private int stockQuantity;

    public Mobile(String id, String name, String brand, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    @Override
    public String toString() {
        return "Mobile [ID=" + id + ", Name=" + name + ", Brand=" + brand + ", Price=" + price + ", Stock Quantity=" + stockQuantity + "]";
    }
}
