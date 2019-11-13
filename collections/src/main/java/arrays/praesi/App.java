package arrays.praesi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        List<Double> myDoubles = new ArrayList<>();
        myDoubles.add(5.5);
        myDoubles.add(5.5);
        myDoubles.add(4.5);
        myDoubles.add(6.0);
        myDoubles.remove(5.5);
        System.out.println("5.5 in list?: " + myDoubles.contains(5.5));
        System.out.println("Value at index 0: " + myDoubles.get(0));


    }
}
