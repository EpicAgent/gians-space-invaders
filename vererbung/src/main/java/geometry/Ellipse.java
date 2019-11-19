package geometry;

public class Ellipse extends Circle {

    private int radiusY;

    public Ellipse(Point center, int radiusX, int radiusY) {
        super(center, radiusX);

        this.radiusY = radiusY;
    }

    public int getRadiusX() {
        return radius;
    }

    public int getRadiusY() {
        return radiusY;
    }
}
