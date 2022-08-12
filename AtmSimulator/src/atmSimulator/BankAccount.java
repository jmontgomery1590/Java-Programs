package atmSimulator;

import java.util.Scanner;

public class BankAccount {
	static double acctBalance = 1000;
	double prevTrans;
	
	public double deposit(double depAmount) {
		if (depAmount != 0) {
		acctBalance += depAmount;
			prevTrans = depAmount;
		}
		return acctBalance;
	}
	
	public double withdrawal(double witAmount) {
		if (witAmount != 0 && acctBalance >= witAmount) {
			acctBalance -= witAmount;
			prevTrans = -witAmount;
		} else if(acctBalance < witAmount){
			System.out.printf("Insufficient funds. Your current balance is $%.2f.\n", acctBalance);
			System.out.println();
		}
		return acctBalance;
	}
	
	public void getPrevTrans() {
		if (prevTrans > 0) {
			System.out.printf("Previous transaction deposited: $%.2f.\n", prevTrans);
		} else if (prevTrans < 0) {
			System.out.printf("Previous transaction withdrew: $%.2f.\n", prevTrans);
		} else {
			System.out.println("No previous transaction occured.\n");
		}
	}
	
	public void accountMenu() {
		int userInput;
		Scanner scnr = new Scanner(System.in);
				
		do {
            System.out.println("\nEnter the number of your desired transaction type:\n");
            System.out.println("1. Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawal");
            System.out.println("4. Previous ");
            System.out.println("5. Quit\n");

            userInput = scnr.nextInt();
            System.out.println();

            switch (userInput) {
            	case 1 ->
            		System.out.printf("Your current balance is $%.2f.\n", acctBalance);
            	case 2 -> {
            		System.out.println("Enter the amount you would like to deposit: ");
            		double depAmount = scnr.nextDouble();
            		deposit(depAmount);
            		System.out.printf("Your account balance is: $%.2f.\n", acctBalance);
            		System.out.println();
            	}
            	case 3 -> {
            		System.out.println("Please enter the amount you would like to withdrawal:");
            		double witAmount = scnr.nextDouble();
            		withdrawal(witAmount);
            		System.out.printf("Your account balance is: $%.2f.\n", acctBalance);
            		System.out.println();
            	}
            	case 4 -> getPrevTrans();
            	case 5 -> {
            		System.out.println("Thank you. Come back soon.");
            		System.exit(0);
            	}
            	default -> System.out.println("Please choose a correct option: ");
            }
		} while (userInput != 5);
        scnr.close();
		System.out.println("Good-bye");        
	}
}
