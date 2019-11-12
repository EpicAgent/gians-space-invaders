package klassen;

public class Line {

    public static void main(String[] args) {
        int x1 = 1;
        int y1 = 1;
        int x2 = 4;
        int y2 = 4;
        double distance = Line.calculateDistance(x1, y1, x2, y2);
        System.out.println("Distance: " + distance);
    }

    public static double calculateDistance(int x1, int y1, int x2, int y2 ){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}

