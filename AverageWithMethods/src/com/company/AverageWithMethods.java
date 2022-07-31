package com.company;

import java.util.Scanner;

public class AverageWithMethods {

    public static void main(String[] args) {
        String userNumbers = getUserNumbers();
        String userInput[] = userNumbers.split(" ");
        if (userInput.length >= 5 && userInput.length <= 10) {
            double inputAvg = inputAverage(userNumbers);
            printAverage(userNumbers, inputAvg);
        }
        else if (userInput.length < 5) {
                System.out.println("You did not enter enough numbers. Please try again.");
        }
        else if (userInput.length > 10) {
                System.out.println("You have entered too many numbers. Please try again.");
        }
    }

    public static String getUserNumbers() {
        String userNumbers;
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter up to ten numbers separated by a space on one line: ");
        userNumbers = scnr.nextLine();
        String userInput[] = userNumbers.split(" ");
        return userNumbers;
    }

    public static double inputAverage(String userNumbers) {
        double inputAvg = 0;
        double inputTotal = 0;
        String userInput[] = userNumbers.split(" ");
        double[] inputNums = new double[userInput.length];

        for (int i = 0; i < userInput.length; i++) {
            String inputString = userInput[i];
            inputNums[i] = Double.parseDouble(inputString);
            inputTotal = inputTotal + inputNums[i];
            inputAvg = inputTotal/userInput.length;
        }
        return inputAvg;
    }

    public static void printAverage(String userNumbers, double inputAvg) {
        System.out.println("The average of the numbers " + userNumbers + " is " + inputAvg);
    }
}
