package hw7;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Task7Test {

        @Test
        public void testRotateRight() {
            assertEquals(4, Task7.rotateRight(8, 1));   // 1000 -> 0100
            assertEquals(1, Task7.rotateRight(16, 1));  // 10000 -> 00001
            assertEquals(6, Task7.rotateRight(17, 2));  // 10001 -> 00110
            // Добавьте дополнительные тесты, если необходимо
        }

        @Test
        public void testRotateLeft() {
            assertEquals(4, Task7.rotateLeft(8, 2));    // 1000 -> 0010
            assertEquals(1, Task7.rotateLeft(16, 4));   // 10000 -> 00001
            assertEquals(6, Task7.rotateLeft(17, 1));   // 10001 -> 00010
            // Добавьте дополнительные тесты, если необходимо
        }
}
