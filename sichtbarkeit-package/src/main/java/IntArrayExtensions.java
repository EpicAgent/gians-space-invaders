import java.util.Arrays;
import java.util.Random;

public class IntArrayExtensions {

    private int[] reversedElements;

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
     *
     * @param size The size of the array.
     * @param min  The smallest possible generated number.
     * @param max  The biggest possible generated number.
     * @return the generated int array.
     */
    static int[] getRandomNumbersInRange(int size, int min, int max) {
        Random random = new Random();
        return random.ints(size, min, max).toArray();
    }

    static int getMax(int[] elements) {

        int currentBiggest = elements[0];
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] > currentBiggest) {
                currentBiggest = elements[i];
            }
        }

        return currentBiggest;
    }

    static int getMin(int[] elements) {
        int currentSmallest = elements[0];
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] < currentSmallest) {
                currentSmallest = elements[i];
            }
        }


        return currentSmallest;
    }

    static double getAverage(int[] elements) {
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum = sum + elements[i];
        }

        return sum / elements.length;
    }

    static int[] sort(int[] elements) {

        int[] copiedElements = Arrays.copyOf(elements, elements.length);
        int length = copiedElements.length;
        int[] sortedElements = new int[length];
        int counter = 0;

        while (counter < length) {
            int currentSmallest = copiedElements[0];
            int currentIndex = 0;
            for (int i = 0; i < copiedElements.length; i++) {
                if (copiedElements[i] < currentSmallest) {
                    currentSmallest = copiedElements[i];
                    currentIndex = i;
                }
            }
            sortedElements[counter] = currentSmallest;
            copiedElements[currentIndex] = Integer.MAX_VALUE;
            counter++;
        }

        return sortedElements;
    }

    static int[] reverse(int[] elements) {

        int[] reversedElements = new int[elements.length];

        for (int i = 0; i < elements.length; i++) {
            reversedElements[elements.length - i - 1] = elements[i];
        }

        return reversedElements;
    }

    static int[] mix(int[] elements) {

        int[] mixedElements = new int[elements.length];
        boolean[] indexWithValues = new boolean[elements.length];

        for (int i = 0; i < elements.length; i++) {
            int randomIndex = getRandomlyFreeIndex(indexWithValues);
            indexWithValues[randomIndex] = true;
            mixedElements[randomIndex] = elements[i];
        }

        return mixedElements;
    }

    static int getRandomlyFreeIndex(boolean[] indexWithValues){
        while (true){
            Random random = new Random();
            int randomIndex = random.nextInt(indexWithValues.length);
            if (indexWithValues[randomIndex] == false){
                return randomIndex;
            }
        }
    }
}
