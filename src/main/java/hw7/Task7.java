package hw7;

public class Task7 {

    public static int rotateLeft(int n, int shift) {
        shift %= 32; // Обрезаем сдвиг до 0-31
        return (n << shift) | (n >>> (32 - shift));
    }

    public static int rotateRight(int n, int shift) {
        shift %= 32; // Обрезаем сдвиг до 0-31
        return (n >>> shift) | (n << (32 - shift));
    }

    public static void main(String[] args) {
        int n1 = 8;
        int shift1 = 1;
        int result1 = rotateRight(n1, shift1);
        System.out.println("rotateRight(" + n1 + ", " + shift1 + ") -> " + result1);

        int n2 = 16;
        int shift2 = 1;
        int result2 = rotateLeft(n2, shift2);
        System.out.println("rotateLeft(" + n2 + ", " + shift2 + ") -> " + result2);

        int n3 = 17;
        int shift3 = 2;
        int result3 = rotateLeft(n3, shift3);
        System.out.println("rotateLeft(" + n3 + ", " + shift3 + ") -> " + result3);
    }
}
