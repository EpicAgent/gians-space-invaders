package geometry;

public class Rectangle {



    public static double calculateArea(int width, int height) {
        double area = width * height;
        return area;
    }

    public static double calculateCircumference(int width, int height) {
        double circumference = 2 * width * height;
        return circumference;
    }
}
