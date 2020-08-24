package account;

public class AccountApp {
    public static void main(String[] args) {
        Person person = new Person("Vorname", "Nachname");
        Account account = new Account(person);
        account.deposit(-100);
    }
}
