package app;

import geometry.Rectangle;

public class RectangleApp {
    public static void main(String[] args) {
        double area = Rectangle.calculateArea(4, 4);
        String areaAsString = Double.toString(area);
        System.out.println("Flaeche: " + areaAsString + "cm");

        double circumference = Rectangle.calculateCircumference(4, 4);
        String circumferenceAsString = Double.toString(circumference);
        System.out.println("Umfang: " + circumferenceAsString + "cm");
    }
}
