package ch.bbcag.ae.ersteschritte;

import javax.swing.*;

public class Bmi {

    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog(null, "Name:");
        int size = Integer.parseInt(JOptionPane.showInputDialog(null, "Grösse (in cm)"));
        int weight = Integer.parseInt(JOptionPane.showInputDialog(null, "Gewicht (in Kg)"));

        double sizeInM = size / 100.0;

        long bmi = Math.round(weight / Math.pow(sizeInM, 2));

        System.out.println("Hallo " + name + ", dein BMI ist " + bmi);

    }

}
