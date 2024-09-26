package com.mobilecenter.models;

import java.time.LocalDate;

public class Sale {
    private String saleId;
    private String mobileId;
    private String customerId;
    private int quantity;
    private double totalPrice;
    private LocalDate date;

    public Sale(String saleId, String mobileId, String customerId, int quantity, double totalPrice, LocalDate date) {
        this.saleId = saleId;
        this.mobileId = mobileId;
        this.customerId = customerId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    // Getters and Setters
    public String getSaleId() { return saleId; }
    public void setSaleId(String saleId) { this.saleId = saleId; }

    public String getMobileId() { return mobileId; }
    public void setMobileId(String mobileId) { this.mobileId = mobileId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    @Override
    public String toString() {
        return "Sale [Sale ID=" + saleId + ", Mobile ID=" + mobileId + ", Customer ID=" + customerId + ", Quantity=" + quantity + ", Total Price=" + totalPrice + ", Date=" + date + "]";
    }
}
