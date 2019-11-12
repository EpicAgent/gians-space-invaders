public class PointApp {
    public static void main(String[] args) {

        Point p1 = new Point();
        p1.setX(1);
        p1.setY(2);

        Point p2 = new Point();
        p2.setX(3);
        p2.setY(4);

        int x1 = p1.getX();
        int y1 = p1.getY();
        int x2 = p2.getX();
        int y2 = p2.getY();

        System.out.println("Point 1: x=" + x1 + ", y=" + y1 + "\nPoint 2: x=" + x2 + ", y=" + y2);
    }
}
