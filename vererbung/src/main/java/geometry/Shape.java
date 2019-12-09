package geometry;

public abstract class Shape {
    protected Color fill = Color.Black;
    protected Point position = new Point(0, 0);

    protected abstract double calculateArea();
    protected abstract double calculateCircumference();

    protected Color getFill() {
        return fill;
    }

    protected void setFill(Color fill) {
        this.fill = fill;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
