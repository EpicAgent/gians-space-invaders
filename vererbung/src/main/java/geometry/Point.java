package geometry;

import java.util.Objects;

public class Point {

    private int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        Point point = (Point) o;
        return x == point.getX() && y == point.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
