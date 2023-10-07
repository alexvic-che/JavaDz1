package hw3;

public class Task3 {
    public static String fixString(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) {
            if (i + 1 < str.length()) {
                result.append(str.charAt(i + 1));
            }
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(fixString("214365")); // Ожидаемый результат: "214365"
        System.out.println(fixString("hTsii  s aimex dpus rtni.g")); // Ожидаемый результат: "This is a mixed up string."

    }
}



