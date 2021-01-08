package geometry;

public class BoundingBox extends Rectangle {

    public BoundingBox(Point topLeft, int height, int width) {
        super(topLeft, width, height);
    }

    public Point getPointTopLeft() {
        return position;
    }

    public Point getPointTopRight() {
        return new Point(position.getX() + getWidth(), position.getY());
    }

    public Point getPointBottomLeft() {
        return new Point(position.getX(), position.getY() + getHeight());
    }

    public Point getPointBottomRight() {
        return new Point(position.getX() + getWidth(), position.getY() + getHeight());
    }

    public boolean isPointInsideRectangle(Point point) {
        return point.getX() >= getPointBottomLeft().getX() && point.getX() <= getPointBottomRight().getX() &&
                point.getY() >= getPointTopLeft().getY() && point.getY() <= getPointBottomLeft().getY();
    }

    public boolean intersect(BoundingBox other) {
        return isPointInsideRectangle(other.getPointTopLeft()) ||
                isPointInsideRectangle(other.getPointTopRight()) ||
                isPointInsideRectangle(other.getPointBottomLeft()) ||
                isPointInsideRectangle(other.getPointBottomRight()) ||

                other.isPointInsideRectangle(this.getPointTopLeft()) ||
                other.isPointInsideRectangle(this.getPointTopRight()) ||
                other.isPointInsideRectangle(this.getPointBottomLeft()) ||
                other.isPointInsideRectangle(this.getPointBottomRight());
    }
}
