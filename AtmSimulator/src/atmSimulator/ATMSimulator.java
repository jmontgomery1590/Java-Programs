package atmSimulator;

public class ATMSimulator extends BankAccount{
	
    public static void main(String[] args) {
        System.out.printf("Welcome! Your current account balance is: $%.2f.\n", acctBalance);
        BankAccount acct1 = new BankAccount();
        acct1.accountMenu();
    }
}