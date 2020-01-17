package arraylist;

public class GenericArrayList<T> {

    private static final int DEFAULT_ARRAY_SIZE = 10;
    private Object[] objects = new Object[DEFAULT_ARRAY_SIZE];
    private int size = 0;

    public void add(T object) {
        if (size == objects.length) {
            grow();
        }
        objects[size] = object;
        size++;
    }

    public T get(int index) {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) objects[index];
    }

    public T[] toArray() {
        Object[] resultArray = new Object[size];
        for (int i = 0; i < size; i++) {
            resultArray[i] = objects[i];
        }
        return (T[]) resultArray;
    }


    public int getSize() {
        return size;
    }

    private void grow() {
        Object[] newNumbers = new Object[objects.length + objects.length / 2];
        for (int i = 0; i < objects.length; i++) {
            newNumbers[i] = objects[i];
        }
        objects = newNumbers;
    }

}
