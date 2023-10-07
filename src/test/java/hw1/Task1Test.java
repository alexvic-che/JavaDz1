package hw1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Task1Test {

    // Тест для корректного времени
    @Test
    public void testValidTimeString() {
        String timeString = "12:44";
        int expectedSeconds = 12 * 60 + 44;
        int actualSeconds = Task1.getVideoLengthInSeconds(timeString);
        assertEquals(expectedSeconds, actualSeconds);
    }
    // Тест для некорректного времени (секунды >= 60)
    @Test
    public void testInvalidTimeString() {
        String invalidTimeString = "12:60"; // Некорректное время (секунды >= 60)
        int actualSeconds = Task1.getVideoLengthInSeconds(invalidTimeString);
        assertEquals(-1, actualSeconds);
    }
    // Тест для некорректного формата времени (больше двух частей)
    @Test
    public void testInvalidFormat() {
        String invalidFormatString = "12:44:00"; // Некорректный формат времени (больше двух частей)
        int actualSeconds = Task1.getVideoLengthInSeconds(invalidFormatString);
        assertEquals(-1, actualSeconds);
    }
    // Тест для нечислового ввода
    @Test
    public void testNonNumericInput() {
        String nonNumericString = "abc:def"; // Не числовой ввод
        int actualSeconds = Task1.getVideoLengthInSeconds(nonNumericString);
        assertEquals(-1, actualSeconds);
    }
}
