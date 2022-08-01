package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) { //Program that asks user to input custom password and compares it against preset criteria.
        Scanner scnr = new Scanner(System.in);

        String inputPassword;
        boolean eightDigit = false;
        boolean hasUppercase = false;
        boolean hasDigit = false;

        System.out.println("Please enter your 8-digit password adhering to the following:");
        System.out.println("1. Must be exactly 8-digits");
        System.out.println("2. Must contain at least one uppercase character");
        System.out.println("3. Must contain at least one numerical digit");
        inputPassword = scnr.next(); //Scanner Class asks user to input their custom password.

        int userPassword = inputPassword.length();

        if (userPassword == 8) { //Checks if user password is exactly 8-digits.
            eightDigit = true;
            if (Character.isUpperCase(inputPassword.charAt(0)) || Character.isUpperCase(inputPassword.charAt(1)) || //Checks if at least one character in password is uppercase.
                    Character.isUpperCase(inputPassword.charAt(2)) || Character.isUpperCase(inputPassword.charAt(3)) ||
                    Character.isUpperCase(inputPassword.charAt(4)) || Character.isUpperCase(inputPassword.charAt(5)) ||
                    Character.isUpperCase(inputPassword.charAt(6)) || Character.isUpperCase(inputPassword.charAt(7))) {
                hasUppercase = true;
                if (Character.isDigit(inputPassword.charAt(0)) || Character.isDigit(inputPassword.charAt(1)) || //Checks that password contains at least one number.
                        Character.isDigit(inputPassword.charAt(2)) || Character.isDigit(inputPassword.charAt(3)) ||
                        Character.isDigit(inputPassword.charAt(4)) || Character.isDigit(inputPassword.charAt(5)) ||
                        Character.isDigit(inputPassword.charAt(6)) || Character.isDigit(inputPassword.charAt(7))) {
                    hasDigit = true;
                }
            }
        }

        if (eightDigit && hasUppercase && hasDigit) { //If password meets all requirements, prints out password is valid.
            System.out.println("The provided password is valid");
        }
        else {
            System.out.println("The provided password is invalid because it must be eight characters in length and " +
                    "include at least one digit and at least one uppercase character. Please try again.");
        }

    }
}
