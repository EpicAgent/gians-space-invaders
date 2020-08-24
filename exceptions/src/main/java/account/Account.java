package account;

public class Account {
    private double balance = 0;
    private double interestRate = 0.01;
    private Person owner;

    public static final String CURRENCY = "CHF";

    public Account(Person owner) {
        this.owner = owner;
    }

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

    public Person getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Owner: ");
        stringBuilder.append(owner.toString());
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("Balance: ");
        stringBuilder.append(Math.round(20 * balance) / 20d); // rounding on 5 cents
        stringBuilder.append(" ");
        stringBuilder.append(CURRENCY);
        return stringBuilder.toString();
    }

    public void setOwner(Person owner) {
        this.owner = owner;
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

    public static Account[] createAccountsForPeople(Person[] people) {
        if (people == null) {
            throw new NullPointerException("Please pass an array of people which is not null.");
        }
        Account[] accounts = new Account[people.length];
        for (int i = 0; i < people.length; i++) {
            accounts[i] = new Account(people[i]);
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
