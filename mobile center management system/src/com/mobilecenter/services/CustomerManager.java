package com.mobilecenter.services;

import com.mobilecenter.models.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers;

    public CustomerManager() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findCustomerById(String customerId) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(customerId))
                .findFirst()
                .orElse(null);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "CustomerManager [Customers=" + customers + "]";
    }
}
