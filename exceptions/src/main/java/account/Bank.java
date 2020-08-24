package account;

public class Bank {
    private Account[] accounts;

    public Bank(Account[] accounts) {
        this.accounts = accounts;
    }

    public void depositToAll(int amount) {
        for (Account account : accounts) {
            try {
                account.deposit(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void withdrawFromAll(int amount) {
        for (Account account : accounts) {
            account.withdraw(amount);
        }
    }
}
