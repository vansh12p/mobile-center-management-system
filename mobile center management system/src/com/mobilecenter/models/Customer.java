package com.mobilecenter.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;
    private String name;
    private String contactDetails;
    private List<Sale> purchaseHistory; // List to store purchases

    public Customer(String id, String name, String contactDetails) {
        this.id = id;
        this.name = name;
        this.contactDetails = contactDetails;
        this.purchaseHistory = new ArrayList<>(); // Initialize the list here
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContactDetails() { return contactDetails; }
    public void setContactDetails(String contactDetails) { this.contactDetails = contactDetails; }

    public List<Sale> getPurchaseHistory() { return purchaseHistory; }

    public void addPurchase(Sale sale) {
        this.purchaseHistory.add(sale); // Add sale to purchase history
    }

    @Override
    public String toString() {
        return "Customer [ID=" + id + ", Name=" + name + ", Contact Details=" + contactDetails + "]";
    }
}
