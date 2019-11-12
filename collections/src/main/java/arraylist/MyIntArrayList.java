package arraylist;


public class MyIntArrayList {
    private static final int DEFAULT_ARRAY_SIZE = 10;
    private int[] numbers = new int[DEFAULT_ARRAY_SIZE];
    private int size = 0;

    public void add(int number) {
        if (size == numbers.length) {
            grow();
        }
        numbers[size] = number;
        size++;
    }

    public int get(int index) {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return numbers[index];
    }

    public int[] toArray() {
        int[] resultArray = new int[size];
        for (int i = 0; i < size; i++) {
            resultArray[0] = numbers[i];
        }
        return resultArray;
    }

    public int getSize() {
        return size;
    }

    private void grow() {
        int[] newNumbers = new int[numbers.length + numbers.length / 2];
        for (int i = 0; i < numbers.length; i++) {
            newNumbers[i] = numbers[i];
        }
        numbers = newNumbers;
    }
}
