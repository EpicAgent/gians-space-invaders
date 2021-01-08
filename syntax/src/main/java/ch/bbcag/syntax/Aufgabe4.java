package ch.bbcag.syntax;

public class Aufgabe4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            String line = i + "-er Reihe: ";

            for (int j = 1; j <= 10; j++) {
                line = line + i * j + " ";
            }
            System.out.println(line);
        }
    }
}
