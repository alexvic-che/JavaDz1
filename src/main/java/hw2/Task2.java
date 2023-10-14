package hw2;

public class Task2
{
    // Интерфейс Shape определяет общие методы и свойства для фигур.
    public interface Shape {
        int getWidth();    // Метод для получения ширины фигуры.
        int getHeight();   // Метод для получения высоты фигуры.
        double area();     // Метод для вычисления площади фигуры.
    }

    // Класс Rectangle реализует интерфейс Shape и представляет прямоугольник.
    public static class Rectangle implements Shape {
        private final int width;
        private final int height;

        // Конструктор для создания прямоугольника с заданными шириной и высотой.
        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        // Реализация метода getWidth для прямоугольника.
        public int getWidth() {
            return width;
        }

        // Реализация метода getHeight для прямоугольника.
        public int getHeight() {
            return height;
        }

        // Реализация метода area для вычисления площади прямоугольника.
        public double area() {
            return width * height;
        }
    }

    // Класс Square также реализует интерфейс Shape и представляет квадрат.
    public static class Square implements Shape {
        private final int side;

        // Конструктор для создания квадрата с заданной стороной.
        public Square(int side) {
            this.side = side;
        }

        // Реализация метода getWidth для квадрата (возвращает сторону).
        public int getWidth() {
            return side;
        }

        // Реализация метода getHeight для квадрата (возвращает сторону).
        public int getHeight() {
            return side;
        }

        // Реализация метода area для вычисления площади квадрата.
        public double area() {
            return side * side;
        }
    }

    public static void main(String[] args) {
        var rectangle = new Rectangle( 4 ,7);
        var square = new Square(4);

        System.out.println(rectangle.area() );
        System.out.println(square.area() );
    }

}
