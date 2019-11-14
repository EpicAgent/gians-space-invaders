package app;

import common.StringExtensions;

public class StringExtensionsApp {
    public static void main(String[] args) {
        String text = "Hallo Welt!";
        System.out.println("reversed: " + StringExtensions.reverse(text));

        String zahl = "12345";
        System.out.println(StringExtensions.sumOfTheDigits(zahl)); // Quersumme
    }
}
