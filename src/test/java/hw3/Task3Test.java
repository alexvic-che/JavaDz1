package hw3;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {

    @Test
    public void testFixStringWithEvenLengthString() {
        String input = "123456";
        String expected = "214365";
        String result = Task3.fixString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testFixStringWithOddLengthString() {
        String input = "hTsii  s aimex dpus rtni.g";
        String expected = "This is a mixed up string.";
        String result = Task3.fixString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testFixStringWithEmptyString() {
        String input = "";
        String expected = "";
        String result = Task3.fixString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testFixStringWithSingleCharacterString() {
        String input = "a";
        String expected = "a";
        String result = Task3.fixString(input);
        assertEquals(expected, result);
    }




}
