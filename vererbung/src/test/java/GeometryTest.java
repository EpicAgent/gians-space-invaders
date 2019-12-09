

import geometry.TextRectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeometryTest {
    @Test
    void rectancle_calculateArea() {
        Rectangle rect = new Rectangle(new Point(1,1),4,5);
        assertEquals(20, rect.calculateArea());
    }

    @Test
    void rectangle_calculateCircumference() {
        Rectangle rect = new Rectangle(new Point(1,1),4,5);
        assertEquals(18, rect.calculateCircumference());
    }

    @Test
    void circle_calculateArea() {
        Circle circle = new Circle(new Point(1,1), 5);
        assertEquals(25 * Math.PI, circle.calculateArea());
    }

    @Test
    void circle_calculateCircumference() {
        Circle circle = new Circle(new Point(1,1),5);
        assertEquals(10 * Math.PI, circle.calculateCircumference());
    }

    @Test
    void textRectangle_calculateArea() {
        TextRectangle textRectangle = new TextRectangle("My Text", new Point(1,1), 4, 5);
        assertEquals(20, textRectangle.calculateArea());
    }

    @Test
    void textRectangle_calculateCircumference() {
        TextRectangle textRectangle = new TextRectangle("My Text", new Point(1,1), 4, 5);
        assertEquals(18, textRectangle.calculateCircumference());
    }

    @Test
    void textRectangle_instanceOf_Rectangle() {
        TextRectangle textRectangle = new TextRectangle("My Text", new Point(1,1), 4, 5);
        assertTrue(textRectangle instanceof Rectangle);
    }

    @Test
    void textRectangle_getText() {
        TextRectangle textRectangle = new TextRectangle("My Text", new Point(1,1), 4, 5);
        assertEquals("My Text", textRectangle.getText());
    }

    @Test
    void circle_getCenter_CorrectCenterGetReturned(){
        Circle circle = new Circle(new Point(1,1),2);
        Point position = circle.getPosition();
        assertEquals(new Point(1, 1), position);
    }

}