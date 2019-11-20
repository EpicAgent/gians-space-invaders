package geometry;

public class Rectangle extends Shape {

    protected Point topLeft;
    protected int width;
    protected int height;

    public Rectangle(Point topLeft, int width, int height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        double area = width * height;
        return area;
    }

    public double calculateCircumference() {
        double circumference = 2 * width * height;
        return circumference;
    }
}
