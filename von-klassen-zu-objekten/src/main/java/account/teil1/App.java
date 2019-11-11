package account.teil1;

public class App {
    public static void main(String[] args) {
        Account[] accounts = Account.createAccounts(10);

        for (int i = 0; i < 10; i++) {
            accounts[i].deposit(RandomHelper.getRandomDouble(1, 1000));
            accounts[i].withdraw(RandomHelper.getRandomDouble(1, 1000));
        }

        Account accountWithMaxBalance = Account.getAccountWithMaxBalance(accounts);
        System.out.println("The max. balance is: " + accountWithMaxBalance.getBalance());
    }
}
