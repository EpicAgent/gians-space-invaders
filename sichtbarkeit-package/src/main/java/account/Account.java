package account;


public class Account {

    private static double balance = 0;
    private static double interestRate = 0.01;
    public static final String CURRENCY = "CHF";


    public static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("The amount has to be greather then 0 when depositing.");
        }
    }

    public static void withdraw(double amount) {
        if (amount > 0) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("The amount has to be greather then 0 when withdrawing.");
        }
    }

    public static double getInterest() {
        return interestRate * balance;
    }

    public static double getBalance() {
        return balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }




}
