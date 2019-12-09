package geometry.auftragsmaterial;

public class Rectangle {
    private int width;
    private int height;
    private Point position;
    private Color fill;

    public Rectangle(Point position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
