package hw1;

public class Task1 {
    public static int getVideoLengthInSeconds(String timeString) {
        // Разделить строку на минуты и секунды
        String[] parts = timeString.split(":");

        // Убедиться, что есть две части (минуты и секунды)
        if (parts.length != 2) {
            return -1; // Некорректный формат
        }

        try {
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);

            // Проверить, что секунды меньше 60
            if (seconds >= 60) {
                return -1; // Некорректный формат
            }

            // Вычислить общую длину видео в секундах
            return minutes * 60 + seconds;
        } catch (NumberFormatException e) {
            return -1; // Некорректный формат (не удалось преобразовать в числа)
        }
    }

    public static void main(String[] args) {
        String timeString = "10:60";
        int videoLengthInSeconds = getVideoLengthInSeconds(timeString);

        if (videoLengthInSeconds != -1) {
            System.out.println("Общая длина видео в секундах: " + videoLengthInSeconds);
        } else {
            System.out.println("-1.");
        }
    }
}
