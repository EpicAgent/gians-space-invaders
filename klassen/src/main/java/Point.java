package klassen;

public class Point {
    private static int x;
    private static int y;

    public static void main(String[] args) {
        Point.setX(2); // Die Werte werden
        Point.setY(3); // zweimal gesetzt

        int x = Point.getX();
        int y = Point.getY();

        System.out.println(x + "," + y);
    }

    public static int getX(){
        return x;
    }
    public static void setX(int x){
        Point.x = x;
    }
    public static int getY(){
        return y;
    }
    public static void setY(int y){
        Point.y = y;
    }
}
