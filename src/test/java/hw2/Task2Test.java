package hw2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Task2Test {
    @Test
    public void testPositiveNumber() {
        int number = 12345;
        int expectedCount = 5;
        int actualCount = Task2.countDigits(number);
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testNegativeNumber() {
        int number = -9876;
        int expectedCount = 4; // Минус не считается
        int actualCount = Task2.countDigits(number);
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testZero() {
        int number = 0;
        int expectedCount = 1; // Есть только одна цифра - 0
        int actualCount = Task2.countDigits(number);
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testLargeNumber() {
        int number = 1234567890;
        int expectedCount = 10;
        int actualCount = Task2.countDigits(number);
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testSingleDigitNumber() {
        int number = 7;
        int expectedCount = 1;
        int actualCount = Task2.countDigits(number);
        assertEquals(expectedCount, actualCount);
    }
}
