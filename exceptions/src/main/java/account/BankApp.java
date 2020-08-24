package account;

public class BankApp {
    public static void main(String[] args) {
        Person person = new Person("Vorname", "Nachname");
        Account account = new Account(person);
        Account[] accounts = {account};

        Bank bank = new Bank(accounts);
        bank.depositToAll(-1000);
    }
}
