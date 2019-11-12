package ch.bbcag.syntax;

import javax.swing.*;

public class Aufgabe9 {
    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog(null, "Name:");
        int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Grösse (in cm)"));
        int weight = Integer.parseInt(JOptionPane.showInputDialog(null, "Gewicht (in Kg)"));

        double sizeInM = size / 100.0;

        long bmi = Math.round(weight / Math.pow(sizeInM, 2));

        System.out.println("Hallo " + name + ", dein BMI ist " + bmi);
    }
}
