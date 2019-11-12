package ch.bbcag.syntax;

public class Aufgabe2 {

    public static void main(String[] args) {
        for (int x = 1; x <= 13; x++) {
            System.out.println("Viel Glück!");
        }

        int counter = 0;
        while (counter < 4) {
            System.out.println("Mein name 1");
            counter++;
        }

        counter = 0;
        do {
            System.out.println("Mein name 2");
            counter++;
        } while(counter < 4);
    }
}

