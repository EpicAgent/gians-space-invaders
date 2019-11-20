import geometry.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class GeometryTest {

    @Test
    void rectancle_setFillAndGetFill_withColorRed() {
        Rectangle rect = new Rectangle(new Point(1,1),2,2);
        rect.setFill(Color.Red);
        assertEquals(Color.Red, rect.getFill());
    }

    @Test
    void circle_setFillAndGetFill_withColorRed() {
        Circle circle = new Circle(new Point(1,1),2);
        circle.setFill(Color.Red);
        assertSame(Color.Red, circle.getFill());
    }

    @Test
    void blueCircle_getFill_CircleIsBlue() {
        BlueCircle circle = new BlueCircle(new Point(1,1),2);
        assertEquals(Color.Blue, circle.getFill());
    }

    @Test
    void circle_getCenter_CorrectCenterReturned(){
        Circle circle = new Circle(new Point(1,1),2);
        Point actualPoint = circle.getCenter();
        assertEquals(new Point(1, 1), actualPoint);
    }

    @Test
    void ellipse_getRadiusX_CorrectRadiusXReturned(){
        Ellipse ellipse = new Ellipse(new Point(1,1),2, 3);
        assertEquals(2, ellipse.getRadiusX());
    }

    @Test
    void ellipse_getRadiusY_CorrectRadiusYReturned(){
        Ellipse ellipse = new Ellipse(new Point(1,1),2, 3);
        assertEquals(3, ellipse.getRadiusY());
    }

    @Test
    void circle_getCenter_CorrectCenterGetReturned(){
        Circle circle = new Circle(new Point(1,1),2);
        Point actualPoint = circle.getCenter();
        assertEquals(new Point(1, 1), actualPoint);
    }
}