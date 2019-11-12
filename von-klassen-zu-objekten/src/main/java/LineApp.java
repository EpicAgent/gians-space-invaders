public class LineApp {

    public static void main(String[] args) {

        Point p1 = new Point();
        p1.setX(4);
        p1.setY(4);

        Point p2 = new Point();
        p2.setX(4);
        p2.setY(4);

        double distance = Line.calculateDistance(p1, p2);

        System.out.println("Distanz zwischen P1 und P2 ist: " + distance);
    }

    public static void mainSolution(String[] args) {

        Point p1 = Point.createPoint(1,1);
        Point p2 = Point.createPoint(4,4);

        double distance = Line.calculateDistance(p1, p2);

        System.out.println("Distanz zwischen P1 und P2 ist: " + distance);
    }
}
