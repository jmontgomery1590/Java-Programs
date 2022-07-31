package FutureValueFrame;

public class FinancialCalculations {
    public static final int MONTHS_PER_YEAR = 12;

    public static double calculateFutureValue(double monthlyPayment, double yearlyInterestRate, int years) {
        int numMonths = years * MONTHS_PER_YEAR;
        double monthlyInterestRate = yearlyInterestRate/MONTHS_PER_YEAR/100;
        double futureValue = 0;
        for (int i = 1; i <= numMonths; i++) {
            futureValue = (futureValue + monthlyPayment) * (1 + monthlyInterestRate);
        }
        return futureValue;
    }
}
