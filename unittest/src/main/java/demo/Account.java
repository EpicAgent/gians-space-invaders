package demo;

import java.math.BigDecimal;
import java.math.MathContext;

public class Account {
    private BigDecimal balance = BigDecimal.valueOf(0);
    private BigDecimal interestRate = BigDecimal.valueOf(0.01);

    public static final String CURRENCY = "CHF";


    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(0)) > 0) {
            balance = balance.add(amount);
        } else {
            throw new IllegalArgumentException("The amount has to be greather then 0 when depositing.");
        }
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(0)) > 0) {
            balance = balance.subtract(amount);
        } else {
            throw new IllegalArgumentException("The amount has to be greather then 0 when withdrawing.");
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Balance: ");
        //stringBuilder.append(Math.round(20 * balance) / 20d); // rounding on 5 cents
        stringBuilder.append(balance.multiply(BigDecimal.valueOf(20)).round(new MathContext(1)).divide(BigDecimal.valueOf(20)));
        stringBuilder.append(" ");
        stringBuilder.append(CURRENCY);
        return stringBuilder.toString();
    }

    public BigDecimal getInterest() {
        return interestRate.multiply(balance);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public static Account getAccountWithMaxBalance(Account[] accounts) {
        Account accountWithMaxBalance = accounts[0];
        for (Account account : accounts) {
            if (account.getBalance().compareTo(accountWithMaxBalance.getBalance()) > 0) {
                accountWithMaxBalance = account;
            }
        }
        return accountWithMaxBalance;
    }
}
