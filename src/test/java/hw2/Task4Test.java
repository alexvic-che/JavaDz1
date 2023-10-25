package hw2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    // Тест для проверки, что метод callingInfo возвращает корректный CallingInfo
    @Test
    void callingInfoShouldReturnCallingInfo() {
        // Подготовка данных

        // Действие: вызов метода, который мы тестируем
        Task4.CallingInfo info = Task4.CallingInfoExtractor.callingInfo();

        //Утверждение: проверка результата
        assertNotNull(info);
        assertNotNull(info.className());
        assertNotNull(info.methodName());
    }



}


