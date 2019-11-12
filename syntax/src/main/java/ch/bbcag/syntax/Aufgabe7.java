package ch.bbcag.syntax;

public class Aufgabe7 {
    public static void main(String[] args) {
        for (int i = 1; i <= 25; ++i) {
            int result = (int) Math.pow(i, 2);
            System.out.println(i + "^2 = " + result);
        }
    }
}
