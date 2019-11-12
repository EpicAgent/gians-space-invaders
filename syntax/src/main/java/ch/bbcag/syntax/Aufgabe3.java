package ch.bbcag.syntax;

public class Aufgabe3 {
    public static void main(String[] args) {
        String output = "*";
        for (int i = 5; i > 0; i--) {
            System.out.println(output);
            output = "*" + output + "*";
        }
    }
}
