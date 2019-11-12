package arraylist;

public class App {
    public static void main(String[] args) {
        useIntArrayList();
        useGenericArrayList();
    }

    private static void useIntArrayList() {
        System.out.println("Int Array List");
        IntArrayList myArrayList = new IntArrayList();
        for (int i = 0; i < 100; i++) {
            myArrayList.add(i);
        }

        for (int i = 0; i < myArrayList.getSize(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }

    private static void useGenericArrayList() {
        System.out.println("Generic Array List");
        GenericArrayList<Integer> myArrayList = new GenericArrayList<>();
        for (int i = 0; i < 100; i++) {
            myArrayList.add(i);
        }

        for (int i = 0; i < myArrayList.getSize(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }


}
