public class StaticPoint {

    private static int x;
    private static int y;

    public static int getX(){
        return StaticPoint.x;
    }
    public static void setX(int x){
        StaticPoint.x = x;
    }
    public static int getY(){
        return StaticPoint.y;
    }
    public static void setY(int y){
        StaticPoint.y = y;
    }
}
