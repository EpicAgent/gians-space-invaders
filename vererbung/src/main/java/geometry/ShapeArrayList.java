package geometry;

import java.util.ArrayList;
import java.util.List;

public class ShapeArrayList extends ArrayList<Shape> {


    public int getAmountOfCircles() {
        int amountOfCircles = 0;
        for (Shape shape : this) {
            if (shape instanceof Circle) {
                amountOfCircles++;
            }
        }
        return amountOfCircles;
    }

    public int getAmountOfRectangles() {
        int amountOfRectangles = 0;
        for (Shape shape : this) {
            if (shape instanceof Rectangle) {
                amountOfRectangles++;
            }
        }
        return amountOfRectangles;
    }

    public List<Rectangle> getAllRectangles() {
        List<Rectangle> allRectangles = new ArrayList<>();
        for (Shape shape : this) {
            if (shape instanceof Rectangle) {
                allRectangles.add((Rectangle)shape);
            }
        }
        return allRectangles;
    }

    public List<Circle> getAllCircles() {
        List<Circle> allCircles = new ArrayList<>();
        for (Shape shape : this) {
            if (shape instanceof Circle) {
                allCircles.add((Circle) shape);
            }
        }
        return allCircles;
    }



}
