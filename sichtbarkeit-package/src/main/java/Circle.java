public class Circle {

    static final double PI = 3.14;

    public static void main(String[] args) {
        int radius = 5;
        double area = calculateArea(radius);
        String areaAsString = Double.toString(area);
        System.out.println("Kreisfläche bei Radius 5 cm: " + areaAsString + "cm");

        double circumference = calculateCircumference(radius);
        String circumferenceAsString = Double.toString(circumference);
        System.out.println("Kreisumfang Radius 5cm: " + circumferenceAsString + "cm");
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

