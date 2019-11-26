package geometry;

public class ShapeArray {

    private Shape[] shapes;

    public ShapeArray(int length) {
        this.shapes = new Shape[length];
    }

    public int getLength(){
        return shapes.length;
    }

    public void put(Shape shape, int index){
        shapes[index] = shape;
    }

    public Shape get(int index){
        return shapes[index];
    }

    public int getAmountOfEllipses(){
        int ellipseCounter = 0;

        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] instanceof Ellipse){
                ellipseCounter++;
            }
        }

        return ellipseCounter;
    }

    public int getAmountOfCircles(){
        int circleCounter = 0;

        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] instanceof Circle){
                circleCounter++;
            }
        }

        return circleCounter;
    }

    public int getAmountOfRectangles(){
        int rectangleCounter = 0;

        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] instanceof Rectangle){
                rectangleCounter++;
            }
        }

        return rectangleCounter;
    }

    public Circle[] getAllCircles(){

        int amountOfCircles = getAmountOfCircles();
        Circle[] circles = new Circle[amountOfCircles];

        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] instanceof Circle) {
                circles[i] = (Circle) shapes[i];
            }
        }

        return circles;
    }

    public Rectangle[] getAllRectangles(){

        int amountOfRectangle = getAmountOfRectangles();
        Rectangle[] rectangle = new Rectangle[amountOfRectangle];

        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] instanceof Rectangle) {
                rectangle[i] = (Rectangle) shapes[i];
            }
        }

        return rectangle;
    }
}
