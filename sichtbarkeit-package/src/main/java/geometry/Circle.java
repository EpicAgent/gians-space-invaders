package geometry;

public class Circle {

    private static final double PI = 3.14;
    private static int radius;

    public static Circle createCircle(int radius) {
        Circle circle =  new Circle();
        circle.setRadius(radius);
        return circle;
    }

    public double calculateArea() {
        double area = PI * (radius * radius);
        return area;
    }

    public double calculateCircumference() {
        double circumference = 2 * PI * radius;
        return circumference;
    }

    public static int getRadius() {
        return radius;
    }

    public static void setRadius(int radius) {
        Circle.radius = radius;
    }
}

