import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class StringExtensionsTest {

    @Test
    void reverse_HappyCase() {
        // Act
        String actual = StringExtensions.reverse( "Hallo Welt!");

        // Assert
        assertEquals("!tleW ollaH", actual);
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "12, 3", "0123, 6", "1000, 1" })
    void sumOfTheDigits(String testData, int result) {
        // Act
        int actual = StringExtensions.sumOfTheDigits(testData);

        // Assert
        assertEquals(result, actual);
    }
}


