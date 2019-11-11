package arraylist;

public class App {
    public static void main(String[] args) {
        useIntArrayList();
        useGenericArrayList();
    }

    private static void useIntArrayList() {
        System.out.println("Int Array List");
        MyIntArrayList myArrayList = new MyIntArrayList();
        for (int i = 0; i < 100; i++) {
            myArrayList.add(i);
        }

        for (int i = 0; i < myArrayList.getSize(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }

    private static void useGenericArrayList() {
        System.out.println("Generic Array List");
        MyGenericArrayList<Integer> myArrayList = new MyGenericArrayList<>();
        for (int i = 0; i < 100; i++) {
            myArrayList.add(i);
        }

        for (int i = 0; i < myArrayList.getSize(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }


}
