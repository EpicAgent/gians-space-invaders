public class Circle {

    static final double PI = 3.14;

    public static void main(String[] args) {
        int radius = 5;
        double area = 4;
        String areaAsString = String.valueOf(calculateArea(radius));
        System.out.println("Kreisfläche bei Radius 5 cm: " + areaAsString + "cm");

        double circumference = calculateCircumference(5);
        String circumferenceAsString = String.valueOf(circumference);
        System.out.println("Kreisumfang Radius 5cm: " + circumferenceAsString + "cm");
    }

    static double calculateArea(int radius) {
        double area = Math.PI * (radius * radius);
        return area;
    }

    static double calculateCircumference(int radius) {
        double circumference = 2 * radius * Math.PI;
        return circumference;
    }
}

