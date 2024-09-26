package com.mobilecenter.main;

import com.mobilecenter.models.Mobile;
import com.mobilecenter.models.Customer;
import com.mobilecenter.models.Sale;
import com.mobilecenter.services.Inventory;
import com.mobilecenter.services.SalesManager;
import com.mobilecenter.services.CustomerManager;

import java.time.LocalDate;
import java.util.Scanner;

public class MobileCenterApp {

    private static Inventory inventory = new Inventory();
    private static SalesManager salesManager = new SalesManager();
    private static CustomerManager customerManager = new CustomerManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addMobile();
                    break;
                case 2:
                    removeMobile();
                    break;
                case 3:
                    listMobiles();
                    break;
                case 4:
                    addCustomer();
                    break;
                case 5:
                    processSale();
                    break;
                case 6:
                    listSalesHistory();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Mobile Center Management System ---");
        System.out.println("1. Add Mobile");
        System.out.println("2. Remove Mobile");
        System.out.println("3. List Mobiles");
        System.out.println("4. Add Customer");
        System.out.println("5. Process Sale");
        System.out.println("6. List Sales History");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addMobile() {
        System.out.print("Enter Mobile ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Mobile Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Mobile Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter Mobile Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Stock Quantity: ");
        int stockQuantity = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Mobile mobile = new Mobile(id, name, brand, price, stockQuantity);
        inventory.addMobile(mobile);
        System.out.println("Mobile added successfully.");
    }

    private static void removeMobile() {
        System.out.print("Enter Mobile ID to remove: ");
        String id = scanner.nextLine();

        inventory.removeMobile(id);
        System.out.println("Mobile removed successfully.");
    }

    private static void listMobiles() {
        System.out.println("\nAvailable Mobiles:");
        inventory.getAllMobiles().forEach(System.out::println);
    }

    private static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Details: ");
        String contactDetails = scanner.nextLine();

        Customer customer = new Customer(id, name, contactDetails);
        customerManager.addCustomer(customer);
        System.out.println("Customer added successfully.");
    }

    private static void processSale() {
        System.out.print("Enter Sale ID: ");
        String saleId = scanner.nextLine();
        System.out.print("Enter Mobile ID: ");
        String mobileId = scanner.nextLine();
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Mobile mobile = inventory.findMobileById(mobileId);
        if (mobile != null && mobile.getStockQuantity() >= quantity) {
            double totalPrice = mobile.getPrice() * quantity;
            Sale sale = new Sale(saleId, mobileId, customerId, quantity, totalPrice, LocalDate.now());

            salesManager.processSale(sale);
            mobile.setStockQuantity(mobile.getStockQuantity() - quantity);
            Customer customer = customerManager.findCustomerById(customerId);
            if (customer != null) {
                customer.addPurchase(sale);
            }

            System.out.println("Sale processed successfully.");
        } else {
            System.out.println("Insufficient stock or mobile not found.");
        }
    }

    private static void listSalesHistory() {
        System.out.println("\nSales History:");
        salesManager.getSalesHistory().forEach(System.out::println);
    }
}
