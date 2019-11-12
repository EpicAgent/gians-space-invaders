package ch.bbcag.syntax;

public class Aufgabe8 {
    public static void main(String[] args) {
        int x1 = 1;
        int y1 = 1;
        int x2 = 4;
        int y2 = 4;
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("Distance: " + distance);
    }
}
