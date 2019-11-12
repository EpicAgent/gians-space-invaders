package account.teil2;

public class App {
    public static void main(String[] args) {
        Person[] accountOwners = PersonDao.getAll();
        Account[] accounts = Account.createAccountsForPeople(accountOwners);

        for (int i = 0; i < 10; i++) {
            accounts[i].deposit(RandomHelper.getRandomDouble(1, 1000));
            accounts[i].withdraw(RandomHelper.getRandomDouble(1, 1000));
        }

        Account accountWithMaxBalance = Account.getAccountWithMaxBalance(accounts);
        System.out.println("The winner account is:");
        System.out.println(accountWithMaxBalance);
    }
}
