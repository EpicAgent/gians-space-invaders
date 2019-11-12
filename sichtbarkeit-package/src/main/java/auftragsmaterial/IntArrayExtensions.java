package auftragsmaterial;

import java.util.Arrays;
import java.util.Random;

public class IntArrayExtensions {

    public static void main(String[] args) {

        int[] tenRandomNumber = getRandomNumbersInRange(10, 0, 9);
        System.out.println("Zufählige Zahlen: " + Arrays.toString(tenRandomNumber));
        System.out.println("Kleinster Wert: " + getMin(tenRandomNumber));
        System.out.println("Grösster Wert: " + getMax(tenRandomNumber));
        System.out.println("Durchschnitt: " + getAverage(tenRandomNumber));
        System.out.println("sortiert: " + Arrays.toString(sort(tenRandomNumber)));
        System.out.println("sortiert und rückwärts: " + Arrays.toString(reverse(sort(tenRandomNumber))));
        System.out.println("sortiert und gemischelt: " + Arrays.toString(mix(sort(tenRandomNumber))));
    }

    /**
     * Creates an array with random number.
     * @param size The size of the array.
     * @param min The smallest possible generated number.
     * @param max The biggest possible generated number.
     * @return the generated int array.
     */
    static int[] getRandomNumbersInRange(int size, int min, int max){
        Random random = new Random();
        return random.ints(size, min, max).toArray();
    }
    static int getMax(int[] elements) {
        return 0; // TODO
    }
    static int getMin(int[] elements) {
        return 0; // TODO
    }
    static double getAverage(int[] elements) {
        return 0; // TODO
    }
    static int[] sort(int[] elements) {
        return null; // TODO
    }
    static int[] reverse(int[] elements) {
        return null; // TODO
    }
    static int[] mix(int[] elements) {
        return null; // TODO
    }
}
