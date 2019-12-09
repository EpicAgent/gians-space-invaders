import geometry.BoundingBox;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoundingBoxTest {

    @Test
    void getPointTopLeftCorrect() {
        BoundingBox boundingBox = new BoundingBox(new Point(1,1), 2, 2);
        assertEquals(new Point(1, 1), boundingBox.getPointTopLeft());
    }

    @Test
    void getPointTopRightCorrect() {
        BoundingBox boundingBox = new BoundingBox(new Point(1,1), 2, 2);
        assertEquals(new Point(3, 1), boundingBox.getPointTopRight());
    }

    @Test
    void getPointBottomLeftCorrect() {
        BoundingBox boundingBox = new BoundingBox(new Point(1,1), 2, 2);
        assertEquals(new Point(1, 3), boundingBox.getPointBottomLeft());
    }

    @Test
    void getPointBottomRightCorrect() {
        BoundingBox boundingBox = new BoundingBox(new Point(1,1), 2, 2);
        assertEquals(new Point(3, 3), boundingBox.getPointBottomRight());
    }

    @Test
    void isPointInRectangleWhenPointIsInRectangle() {
        BoundingBox boundingBox = new BoundingBox(new Point(1,1), 2, 2);
        assertEquals(true, boundingBox.isPointInsideRectangle(new Point(2, 2)));
    }

    @ParameterizedTest
    @CsvSource({"0, 2", "2, 0", "4, 2", "2, 4" })
    void isPointInRectangleWhenPointIsNotInRectangle(int x, int y) {
        BoundingBox boundingBox = new BoundingBox(new Point(1,1), 2, 2);
        assertEquals(false, boundingBox.isPointInsideRectangle(new Point(x, y)));
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "0, 2", "2, 0", "2, 2", "3, 1", "1, 3", "3, 2", "-1, -1" })
    void intersectWhenRectancleIntersect(int x, int y) {
        BoundingBox boundingBox = new BoundingBox(new Point(1,1), 2, 2);
        assertEquals(true, boundingBox.intersect(new BoundingBox(new Point(x, y), 2, 2)));
    }

    @ParameterizedTest
    @CsvSource({"4, 2", "2, 4", "-2, 0" })
    void intersectWhenRectancleNotIntersect(int x, int y) {
        BoundingBox boundingBox = new BoundingBox(new Point(1,1), 2, 2);
        assertEquals(false, boundingBox.intersect(new BoundingBox(new Point(x, y), 2, 2)));
    }

}
