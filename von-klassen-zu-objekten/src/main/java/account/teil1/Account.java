package account.teil1;

public class Account {
    private double balance = 0;
    private double interestRate = 0.01;
    public static final String CURRENCY = "CHF";

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("The amount has to be greather then 0 when depositing.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("The amount has to be greather then 0 when withdrawing.");
        }
    }

    public double getInterest() {
        return interestRate * balance;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public static Account[] createAccounts(int numberOfAccountsToCreate) {
        Account[] accounts = new Account[numberOfAccountsToCreate];
        for (int i = 0; i < numberOfAccountsToCreate; i++) {
            accounts[i] = new Account();
        }
        return accounts;
    }

    public static Account getAccountWithMaxBalance(Account[] accounts) {
        Account accountWithMaxBalance = accounts[0];
        for (Account account : accounts) {
            if (account.getBalance() > accountWithMaxBalance.getBalance()) {
                accountWithMaxBalance = account;
            }
        }
        return accountWithMaxBalance;
    }
}
