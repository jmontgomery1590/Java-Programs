package com.company;

import java.util.Scanner;

public class ATMSimulator {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        double acctBalance = 1000.00;
        double inputDeposit;
        double inputWithdrawal;
        int userInput;

        System.out.printf("Welcome! Your current account balance is: $%.2f.\n",acctBalance);

        System.out.println("Enter the number of your desired transaction type:");
        System.out.println("1. Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdrawal");
        System.out.println("4. Quit");

        userInput = scnr.nextInt();

        if (userInput == 1) {
            System.out.printf("Your current balance is $%.2f.\n", acctBalance);
        }

        else if (userInput == 2) {
            System.out.println("Please enter the amount of your deposit:");
            inputDeposit = scnr.nextDouble();

            System.out.printf("Your deposit amount is: $%.2f.\n", inputDeposit);
            acctBalance = acctBalance + inputDeposit;
            System.out.printf("Your new balance is: $%.2f.\n", acctBalance);
        }

        else if (userInput == 3) {
            System.out.println("Please enter the amount you would like to withdrawal:");
            inputWithdrawal = scnr.nextDouble();

            if (inputWithdrawal <= acctBalance) {
                acctBalance = acctBalance - inputWithdrawal;
                System.out.printf("Your new account balance is: $%.2f.\n", acctBalance);


            } else {
                System.out.printf("Insufficient funds. Your current balance is $%.2f.\n", acctBalance);
            }
        }

        else if (userInput == 4) {
            System.out.println("Good-bye");
        }

        else {
            System.out.println("Invalid menu choice.");
        }
    }
}
