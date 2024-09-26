package com.mobilecenter.services;

import com.mobilecenter.models.Sale;
import java.util.ArrayList;
import java.util.List;

public class SalesManager {
    private List<Sale> sales;

    public SalesManager() {
        this.sales = new ArrayList<>();
    }

    public void processSale(Sale sale) {
        sales.add(sale);
    }

    public List<Sale> getSalesHistory() {
        return sales;
    }

    @Override
    public String toString() {
        return "SalesManager [Sales=" + sales + "]";
    }
}
