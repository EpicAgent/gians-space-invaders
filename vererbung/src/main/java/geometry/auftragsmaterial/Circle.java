package geometry.auftragsmaterial;

public class Circle {
    private int radius;
    private Point position;
    private Color fill;

    public Circle(Point position, int radius) {
        this.radius = radius;
        this.position = position;
    }

    public int getRadius() {
        return radius;
    }

    public Point getPosition() {
        return position;
    }

    public Color getFill() {
        return fill;
    }

    public void setFill(Color fill) {
        this.fill = fill;
    }
}
