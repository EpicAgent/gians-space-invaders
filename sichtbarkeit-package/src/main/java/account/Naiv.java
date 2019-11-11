package account;

public class Naiv {


    /**
     * So würden unsere Lernenden wahrscheinlich das Bankkonto ohne Klassen implementieren
     * @param args
     */
    public static void main(String[] args) {
        double balance = 0;
        double interestRate = 0.01; // Zinssatz
        String currency = "CHF";
        balance += 100; // Geld einzahlen
        balance -= 10; // Geld abheben
        double interest = balance * interestRate; // Zinsen
        System.out.println("Zinsen: " + interest);
    }
}
