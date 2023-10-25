package hw2;

public class Task1 {
    // Интерфейс для представления выражений.
    public interface Expr {
        double evaluate(); // Метод для вычисления значения выражения.
    }

    // Запись для представления константы (числа).
    public record Constant(double value) implements Expr {
        public double evaluate() {
            return value; // Просто возвращает значение константы.
        }
    }

    // Запись для представления отрицания числа (унарный минус).
    public record Negate(Expr operand) implements Expr {
        public double evaluate() {
            return -operand.evaluate(); // Отрицание операнда.
        }
    }

    // Запись для представления возведения в степень.
    public record Exponent(Expr base, int power) implements Expr {
        public double evaluate() {
            return Math.pow(base.evaluate(), power); // Возводит основание в степень.
        }
    }

    // Запись для представления сложения двух выражений.
    public record Addition(Expr left, Expr right) implements Expr {
        public double evaluate() {
            return left.evaluate() + right.evaluate(); // Складывает два операнда.
        }
    }

    // Запись для представления умножения двух выражений.
    public record Multiplication(Expr left, Expr right) implements Expr {
        public double evaluate() {
            return left.evaluate() * right.evaluate(); // Умножает два операнда.
        }

        public static void main(String[] args) {
            // Создание объектов, представляющих выражения и их вложенность.
            var two = new Constant(2);
            var four = new Constant(4);
            var negOne = new Negate(new Constant(1));
            var sumTwoFour = new Addition(two, four);
            var mult = new Multiplication(sumTwoFour, negOne);
            var exp = new Exponent(mult, 2);
            var res = new Addition(exp, new Constant(1));

            // Вывод строки, представляющей выражение, и его вычисленное значение.
            System.out.println(res + " = " + res.evaluate());
        }
    }

}
