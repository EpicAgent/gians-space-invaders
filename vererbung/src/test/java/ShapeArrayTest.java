import geometry.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeArrayTest {

    @Test
    void construktorSetLengthCorrect() {
        ShapeArray shapes = new ShapeArray(5);
        assertEquals(5, shapes.getLength());
    }

    @Test
    void putShapeAndGetShapeCorrect() {
        ShapeArray shapes = new ShapeArray(5);
        BlueCircle blueCircle = new BlueCircle(new Point(1,1),2);
        shapes.put(blueCircle, 2);
        Shape expected = shapes.get(2);

        assertSame(expected, blueCircle);
    }

    @Test
    void shapeArrayContainsFourShapes() {
        ShapeArray shapes = createShapeArrayWithTestdata();
        assertEquals(4, shapes.getLength());
    }
    @Test
    void shapeArrayContainsOneEllipse() {
        ShapeArray shapes = createShapeArrayWithTestdata();
        assertEquals(1, shapes.getAmountOfEllipses());
    }

    @Test
    void shapeArrayContainsThreeCircles() { // The Ellipse and the BlueCircle are also Circles
        ShapeArray shapes = createShapeArrayWithTestdata();
        assertEquals(3, shapes.getAmountOfCircles());
    }

    @Test
    void shapeArrayContainsOneRectangles() {
        ShapeArray shapes = createShapeArrayWithTestdata();
        assertEquals(1, shapes.getAmountOfRectangles());
    }

    @Test
    void shapeArrayGetAllRectanglesCorrect(){
        ShapeArray shapes = new ShapeArray(4);
        Rectangle expectedRectangle = new Rectangle(new Point(1, 1),2,2);
        shapes.put(expectedRectangle, 0);
        Rectangle actualRectangle = shapes.getAllRectangles()[0];
        assertSame(expectedRectangle, actualRectangle);
    }

    @Test
    void shapeArrayGetAllCirclesCorrect(){
        ShapeArray shapes = new ShapeArray(4);
        BlueCircle expectedCircle = new BlueCircle(new Point(1, 1),2);
        shapes.put(expectedCircle, 0);
        Circle actualCircle = shapes.getAllCircles()[0];
        assertSame(expectedCircle, actualCircle);
    }

    private ShapeArray createShapeArrayWithTestdata(){
        Point center = new Point(1, 1);
        Circle circle = new Circle(center, 1);
        Ellipse ellipse = new Ellipse(center, 1, 2);
        BlueCircle blueCircle = new BlueCircle(center, 1);
        Rectangle rect = new Rectangle(center,2,2);

        ShapeArray shapes = new ShapeArray(4);
        shapes.put(circle, 0);
        shapes.put(ellipse, 1);
        shapes.put(blueCircle, 2);
        shapes.put(rect, 3);

        return shapes;
    }
}