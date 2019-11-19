package geometry;

public class BoundingBox extends Rectangle {

    public BoundingBox(Point topLeft, int height, int width) {
        super(topLeft, height, width);
    }

    public Point getPointTopLeft() {
        return topLeft;
    }

    public Point getPointTopRight() {
        return new Point(topLeft.getX() + width, topLeft.getY());
    }

    public Point getPointBottomLeft() {
        return new Point(topLeft.getX(), topLeft.getY() + height );
    }

    public Point getPointBottomRight() {
        return new Point(topLeft.getX() + width, topLeft.getY() + height);
    }

    public boolean isPointInsideRectangle(Point point){
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
