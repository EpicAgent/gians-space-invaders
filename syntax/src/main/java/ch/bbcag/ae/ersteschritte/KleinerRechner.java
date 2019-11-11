package ch.bbcag.ae.ersteschritte;

import javax.swing.*;

public class KleinerRechner {

    public static void main(String[] args) {

        double zahl1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Zahl 1:"));
        double zahl2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Zahl 2:"));
        String operator = JOptionPane.showInputDialog(null, "Operator: (+*/-%)");

        double result;
        switch (operator) {
            case "+":
                result = zahl1 + zahl2;
                break;
            case "*":
                result = zahl1 * zahl2;
                break;
            case "/":
                result = zahl1 / zahl2;
                break;
            case "-":
                result = zahl1 - zahl2;
                break;
            case "%":
                result = zahl1 % zahl2;
                break;
            default:
                System.out.println("Ungültiger Operator: " + operator);
                return;
        }

        System.out.println("Das Resultat ist: " + result);

    }

}
