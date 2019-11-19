package geometry;

import geometry.Color;
import geometry.Point;

public class Circle extends Shape {

    private Point center;
    protected int radius;

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

    public Point getCenter() {
        return center;
    }

    public int getRadius(){
        return this.radius;
    }
}
