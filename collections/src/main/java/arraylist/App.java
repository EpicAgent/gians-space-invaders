package arraylist;

import arraylist.interfaces.IIntList;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        useLottoGenerator();
        useIntArrayList();
        useArrayList();
        useGenericArrayList();
    }

    private static void useLottoGenerator() {
        IIntList lottoNumbers = LottoGenerator.generateLottoNumbers();
        System.out.println("This weeks lotto numbers are:");
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.println(lottoNumbers.get(i));
        }
    }

    private static void useIntArrayList() {
        System.out.println("Int Array List");
        IntArrayList myArrayList = new IntArrayList();
        myArrayList.add(5);
        for (int i = 0; i < 100; i++) {
            myArrayList.add(i);
        }

        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }

    private static void useArrayList() {
        System.out.println("java.util.ArrayList");
        ArrayList<Integer> myArrayList = new ArrayList<>();
        myArrayList.add(5);
        for (int i = 0; i < 100; i++) {
            myArrayList.add(i);
        }

        for (int i = 0; i < myArrayList.size(); i++) {
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
