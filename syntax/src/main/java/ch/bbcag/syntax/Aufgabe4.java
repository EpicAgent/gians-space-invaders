package ch.bbcag.syntax;

public class Aufgabe4 {
    public static void main(String[] args) {

        String line;
        int result;

        for (int i = 1; i <= 10; i++) {
            line = Integer.toString(i) + "-er Reihe: ";

            for (int j = 1; j <= 10; j++) {
                result = i * j;
                line = line + Integer.toString(result) + " ";
            }

            System.out.println(line);
        }
    }
}
