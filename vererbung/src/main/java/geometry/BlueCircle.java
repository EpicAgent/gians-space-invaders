package geometry;

import geometry.Point;

public class BlueCircle extends Circle {

    public BlueCircle(Point center, int radius) {
        super(center, radius);

        super.fillColor = Color.Blue;
    }
}
