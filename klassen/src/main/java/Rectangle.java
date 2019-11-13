public class Rectangle {

    public static void main(String[] args) {
        double area = calculateArea(4, 5);
        System.out.println("Flaeche: " + area + "cm");

        double circumference = calculateCircumference(4, 5);
        System.out.println("Umfang: " + circumference + "cm");
    }

    static double calculateArea(double width, double height) {
        double area = width * height;
        return area;
    }

    static double calculateCircumference(int width, int height) {
        double circumference = (2 * width) + (2 * height);
        return circumference;
    }
}
