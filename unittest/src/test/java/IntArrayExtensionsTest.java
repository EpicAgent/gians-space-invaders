import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntArrayExtensionsTest {

    @Test
    void getMax_HappyCase() {
        // Arrange
        int[] testData = new int[] { 2, 1, 4, 3};

        // Act
        int actual = IntArrayExtensions.getMax(testData);

        // Assert
        assertEquals(4, actual);
    }

    @Test
    void getMin_HappyCase() {
        // Arrange
        int[] testData = new int[] { 2, 1, 4, 3};

        // Act
        int actual = IntArrayExtensions.getMin(testData);

        // Assert
        assertEquals(1, actual);
    }

    @Test
    void getAvarage_HappyCase() {
        // Arrange
        int[] testData = new int[] { 2, 1, 4, 3};

        // Act
        double actual = IntArrayExtensions.getAverage(testData);

        // Assert
        assertEquals(2.0, actual);
    }

    @Test
    void sort_HappyCase() {
        // Arrange
        int[] testData = new int[] { 2, 1, 4, 3};

        // Act
        int[] actual = IntArrayExtensions.sort(testData);

        // Assert
        assertArrayEquals(new int[] { 1, 2, 3, 4}, actual);
    }

    @Test
    void reverse_HappyCase() {
        // Arrange
        int[] testData = new int[] { 1, 2, 3, 4};

        // Act
        int[] actual = IntArrayExtensions.reverse(testData);

        // Assert
        assertArrayEquals(new int[] { 4, 3, 2, 1}, actual);
    }
}