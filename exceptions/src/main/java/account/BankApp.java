package account;

import javax.swing.*;

public class BankApp {
    public static void main(String[] args) {
        Thread.currentThread().setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(e.getMessage());
            }
        });

        Person person = new Person("Vorname", "Nachname");
        Account account = new Account(person);
        Account[] accounts = {account};

        Bank bank = new Bank(accounts);
        bank.depositToAll(-1000);
    }
}
