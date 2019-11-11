import java.util.Arrays;
import java.util.Random;

public class IntArrayExtensions {

    public static void main(String[] args) {
        int[] tenRandomNumber = getRandomNumbersInRange(10, 0, 9);
        System.out.println("Zufällige Zahlen: " + Arrays.toString(tenRandomNumber));
        System.out.println("Kleinster Wert: " + getMin(tenRandomNumber));
        System.out.println("Grösster Wert: " + getMax(tenRandomNumber));
        System.out.println("Durchschnitt: " + getAverage(tenRandomNumber));
        System.out.println("rückwärts: " + Arrays.toString(reverse(tenRandomNumber)));
        System.out.println("sortiert: " + Arrays.toString(sort(tenRandomNumber)));
        System.out.println("sortiert und rückwärts: " + Arrays.toString(reverse(sort(tenRandomNumber))));
        System.out.println("sortiert und wieder gemischt: " + Arrays.toString(mix(sort(tenRandomNumber))));
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
        int max = elements[0];
        for (int i = 0; i < elements.length; i++) {
            if (max < elements[i]) {
                max = elements[i];
            }
        }
        return max;
    }
    static int getMin(int[] elements) {
        int min = elements[0];
        for (int i = 0; i < elements.length; i++) {
            if (min > elements[i]) {
                min = elements[i];
            }
        }
        return min;
    }
    static double getAverage(int[] elements) {
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum += elements[i];
        }
        return (double) sum / elements.length;
    }

    // https://www.javatpoint.com/bubble-sort-in-java
    static int[] sort(int[] elements) {
        int[] newArray = Arrays.copyOf(elements, elements.length);
        int length = elements.length;
        int temp = 0;
        for(int i = 0; i < length; i++){
            for(int j = 1; j < (length-i); j++){
                if(newArray[j - 1] > newArray[j]){
                    //swap elements
                    temp = newArray[j - 1];
                    newArray[j - 1] = newArray[j];
                    newArray[j] = temp;
                }

            }
        }
        return newArray;
    }

    static int[] reverse(int[] elements) {
        int[] result = new int[elements.length];
        int resultPosition = 0;
        for (int i = elements.length - 1; i >= 0; i--) {
            result[resultPosition] = elements[i];
            resultPosition++;
        }
        return result;
    }

    //https://www.programcreek.com/2012/02/java-method-to-shuffle-an-int-array-with-random-order/
    static int[] mix(int[] elements) {
        Random rgen = new Random();  // Random number generator

        for (int i=0; i < elements.length; i++) {
            int randomPosition = rgen.nextInt(elements.length);
            int temp = elements[i];
            elements[i] = elements[randomPosition];
            elements[randomPosition] = temp;
        }

        return elements;
    }
}
