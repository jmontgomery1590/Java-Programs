package com.company;

import java.util.Scanner;

public class Main {

    public static void bannerPrinter() {
        System.out.println("******************************************");
        System.out.println("====== Welcome to my eCommerce app! ======");
        System.out.println("******************************************");
        System.out.println();
    }

    public static String productsBuilder() {
        String productsCatalog = "Desk      Table     Pen       ";
        return productsCatalog;
    }

    public static boolean getOrder(String productsCatalog) {
        String userInput;
        boolean exists = false;
        Scanner scnr = new Scanner(System.in);

        System.out.println("Please choose one product: ");
        userInput = scnr.nextLine();
        if (productsBuilder().contains(userInput)) {
            exists = true;
        }
        else {
            exists = false;
        }
        return exists;
    }

    public static double getPrice() {
        double price = (Math.random() * 100) + 1;
        return price;
    }

    public static double getTax(double price) {
        double tax = (0.1 * getPrice());
        return tax;
    }

    public static double getTotal(double price, double tax) {
        double saleTotal = getPrice() + getTax(price);
        return saleTotal;
    }

    public static void printTotal(double salesTotal) {
	    double price = 0;
	    double tax = 0;
	    System.out.printf("Your sale total is: $%.2f", getTotal(price, tax));
	    System.out.println();
    }

    public static void main(String[] args) {
        String productsCatalog = " ";
        bannerPrinter();
        System.out.println("Your catalog contains: Desk, Table, Pen");
        productsBuilder();

        boolean exists = getOrder(productsCatalog);
        if (exists == true) {
            double salesTotal = 0;
            printTotal(salesTotal);
        }
        else {
            System.out.println("The product is not found.");
        }
    }
}
