package app;

import geometry.Line;

public class LineApp {

    public static void main(String[] args) {
        int x1 = 1;
        int y1 = 1;
        int x2 = 4;
        int y2 = 4;
        double distance = Line.calculateDistance(x1, y1, x2, y2);
        System.out.println("Distance: " + distance);
    }
}
