package klassen;

public class Circle {

    static final double PI = 3.14;

    public static void main(String[] args) {
        int radius = 5;
        double area = calculateArea(radius);
        System.out.println("Kreisfläche bei Radius 5 cm: " + area + "cm");

        double circumference = calculateCircumference(radius);
        System.out.println("Kreisumfang Radius 5cm: " + circumference + "cm");
    }

    static double calculateArea(int radius) {
        double area = PI * (radius * radius);
        return area;
    }

    static double calculateCircumference(int radius) {
        double circumference = 2 * radius * radius;
        return circumference;
    }
}

