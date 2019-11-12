package ch.bbcag.syntax;

public class Aufgabe13 {
    public static void main(String[] args) {
        long[] numbersAsLong = { 10, 20, 30};

        int[] numberAsInteger = new int[numbersAsLong.length];
        int counter = 0;
        for (long number : numbersAsLong){
            numberAsInteger[counter] = (int) number;
            counter++;
        }

        for (int number : numberAsInteger){
            System.out.println(number);
        }
    }
}
