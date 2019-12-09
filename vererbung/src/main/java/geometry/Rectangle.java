package geometry;

public class Rectangle extends Shape {


    private int width;
    private int height;

    public Rectangle(Point topLeft, int width, int height) {
        this.position = topLeft;
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        double area = width * height;
        return area;
    }

    @Override
    public double calculateCircumference() {
        double circumference = (2 * width) + (2 * height);
        return circumference;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
