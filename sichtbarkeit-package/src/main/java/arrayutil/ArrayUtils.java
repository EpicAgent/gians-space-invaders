package arrayutil;

public class ArrayUtils {

    public static int[] getEven(int[] numbers) {
        int evenNumbersCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenNumbersCount++;
            }
        }
        int[] evenNumbers = new int[evenNumbersCount];
        int evenNumbersIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenNumbers[evenNumbersIndex++] = numbers[i];
            }
        }
        return evenNumbers;

    }

    public static int getMin(int[] numbers) {
        if (isNullOrEmpty(numbers)) {
            throw new IllegalArgumentException("Array can not be null or empty.");
        }
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public static int getMax(int[] numbers) {
        if (isNullOrEmpty(numbers)) {
            throw new IllegalArgumentException("Array can not be null or empty.");
        }
        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static int getSum(int[] numbers) {
        if (isNullOrEmpty(numbers)) {
            throw new IllegalArgumentException("Array can not be null or empty.");
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static double getAverage(int[] numbers) {
        if (isNullOrEmpty(numbers)) {
            throw new IllegalArgumentException("Array can't be null or empty.");
        }
        int sum = getSum(numbers);
        return sum / numbers.length;
    }

    public static boolean isNullOrEmpty(int[] numbers) {
        return numbers == null || numbers.length <= 0;
    }


}
