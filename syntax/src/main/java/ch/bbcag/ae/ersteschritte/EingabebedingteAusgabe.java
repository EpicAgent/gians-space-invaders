package ch.bbcag.ae.ersteschritte;

import javax.swing.*;

public class EingabebedingteAusgabe {

    public static void main(String[] args) {
        int zahl = Integer.parseInt(JOptionPane.showInputDialog(null, "Bitte Zahl eingeben"));

        if (zahl > 0) {
            System.out.println("Ihre Zahl ist grösser 0");
        } else if (zahl < 0) {
            System.out.println("Ihre Zahl ist kleiner 0");
        } else {
            System.out.println("Ihre Zahl ist die 0");
        }
    }
}
