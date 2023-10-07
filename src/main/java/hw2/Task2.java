package hw2;

public class Task2 {
    public static int countDigits(int number) {
        // Если число отрицательное, преобразуйте его в положительное
        if (number < 0) {
            number = -number;
        }

        // Инициализируйте счетчик цифр
        int digitCount = 1; // По умолчанию, у нас есть хотя бы одна цифра (0)

        // Пока число больше 0, увеличивайте счетчик цифр и делим число на 10
        while (number > 0) {
            number /= 10;
            if (number > 0) {
                digitCount++;
            }
        }

        return digitCount;
    }

    public static void main(String[] args) {
        int number = 4666;
        int digitCount = countDigits(number);
        System.out.println("Количество цифр в числе " + number + " равно " + digitCount);
    }
}
