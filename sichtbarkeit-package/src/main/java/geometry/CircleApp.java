package geometry;

// Default-Package
public class CircleApp {
    public static void main(String[] args) {
        int radius = 5;
        Circle circle = Circle.createCircle(radius);
        double area = circle.calculateArea();
        String areaAsString = Double.toString(area);
        System.out.println("Flaeche bei Radius 5 cm: " + areaAsString + "cm");

        double circumference = circle.calculateCircumference();
        String circumferenceAsString = Double.toString(circumference);
        System.out.println("Umfang Radius 5cm: " + circumferenceAsString + "cm");
    }
}
