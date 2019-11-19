package geometry.unterichtsmaterial;

public class Circle {

    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public double calculateArea() {
        double area = Math.PI * (radius * radius);
        return area;
    }

    public double calculateCircumference() {
        double circumference = 2 * radius * radius;
        return circumference;
    }
}
