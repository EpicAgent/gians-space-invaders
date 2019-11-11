package ch.bbcag.syntax;

import java.util.Arrays;

public class ArrayUndOperatoren {

    public static void main(String[] args) {
        // a
        int[] bar = new int[100];
        for (int i = 0; i < bar.length; ++i) {
            bar[i] = i;
        }
        System.out.println(Arrays.toString(bar));

        int summe = 0;
        for (int zahl : bar) {
            summe += zahl;
        }
        System.out.println("Summe: " + summe);

        // b
        for (int i = 0; i < bar.length; ++i) {

            if (bar[i] % 2 == 0) {
                ++bar[i];
            } else {
                --bar[i];
            }
        }
        System.out.println(Arrays.toString(bar));

        // c
        int produkt = 1;
        for (int i = 0; i <= 20; ++i) {
            produkt *= bar[i];
        }
        System.out.println("Produkt: " + produkt); // Ergibt 0, da eine der multiplizierten Zahlen 0 ist

    }
}
