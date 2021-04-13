package ch.bbcag.syntax;

import javax.swing.*;

public class Aufgabe6 {
    public static void main(String[] args) {
        while(true) {

            String name = JOptionPane.showInputDialog(null, "Bitte Namen eingeben");

            if (name.equals("MeinName")) {
                System.out.println("Das bin ich!");
                return;
            } else {
                System.out.println("Das bin ich nicht!");
            }
        }
    }
}
