package hw7;

public class Task7 {

    public static int rotateLeft(int n, int shift) {
        shift %= 32; // Убедимся, что сдвиг находится в пределах 32 бит
        return (n << shift) | (n >>> (32 - shift));
    }

    public static int rotateRight(int n, int shift) {
        shift %= 32; // Убедимся, что сдвиг находится в пределах 32 бит
        return (n >>> shift) | (n << (32 - shift));
    }

    public static void main(String[] args) {
        System.out.println(rotateRight(8, 1));  // 1000 -> 0100
        System.out.println(rotateLeft(16, 1));  // 10000 -> 00001
        System.out.println(rotateLeft(17, 2));  // 10001 -> 00110
    }
}
