package geometry;

public class Circle extends Shape {
    private int radius;

    public Circle(Point center, int radius) {
        this.radius = radius;
        this.position = center;
    }

    public double calculateArea() {
        double area = Math.PI * (radius * radius);
        return area;
    }

    public double calculateCircumference() {
        double circumference = 2 * radius * Math.PI;
        return circumference;
    }
}
