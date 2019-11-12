package ch.bbcag.syntax;

import java.util.Arrays;
import java.util.Random;

public class Aufgabe15 {
    public static void main(String[] args) {
        // a
        Random randomGenerator = new Random();

        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; ++i) {
            numbers[i] = randomGenerator.nextInt();
        }

        // b
        System.out.println(Arrays.toString(numbers));

        // c
        double min = Double.MAX_VALUE;
        double max = Double.MAX_VALUE;

        for (double number : numbers) {
            if (number < min) {
                min = number;
            }

            if (number > max) {
                max = number;
            }
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

        // d
        int sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        System.out.println("Summe: " + sum);

        // e
        double mean = sum / numbers.length;
        System.out.println("Durchschnitt: " + mean);

        // f + g
        int[] evens = getEven(numbers);
        System.out.println("Evens: " + Arrays.toString(evens));
    }

    private static int[] getEven(int[] numbers) {
        int[] evens = new int[numbers.length];
        int evenCount = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                evens[evenCount] = number;

                ++evenCount;
            }
        }

        int[] result = new int[evenCount];
        for (int i = 0; i < result.length; ++i) {
            result[i] = evens[i];
        }

        return result;
    }
}
