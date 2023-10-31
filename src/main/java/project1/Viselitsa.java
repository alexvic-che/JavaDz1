package project1;

import java.util.Random;
import java.util.Scanner;

public class Viselitsa {
    private static final String[] WORDS = {"hello", "world", "java", "programming", "hangman"};
    private static final int MAX_MISTAKES = 5;

    private String wordToGuess;
    private char[] guessedWord;
    private int mistakes;

    public Viselitsa() {
        this.wordToGuess = getRandomWord(WORDS);
        this.guessedWord = new char[wordToGuess.length()];
        this.mistakes = 0;

        // Заполняем массив символами '*', чтобы скрыть слово
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord[i] = '*';
        }
    }

    // Проверка, что длина слова находится в допустимом диапазоне
    public boolean isWordLengthValid(String word) {
        return word.length() >= 3 && word.length() <= 12;
    }

    // Проверка, проиграна ли игра
    public boolean isGameLost() {
        return mistakes >= MAX_MISTAKES;
    }

    // Проверка, выиграна ли игра
    public boolean isGameWon() {
        return String.valueOf(guessedWord).equals(wordToGuess);
    }

    // Проверка, что ввод состоит из одной буквы
    public static boolean isInputValid(String input) {
        return input.length() == 1;
    }

    // Выбор случайного слова из словаря
    private static String getRandomWord(String[] words) {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    // Обновление угадываемого слова
    private void updateGuessedWord(char guess) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                guessedWord[i] = guess;
            }
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Viselitsa!");
        printGameState();

        while (!isGameLost()) {
            System.out.print("Guess a letter or type 'surrender' to give up: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("surrender")) {
                System.out.println("You surrendered. The word was: " + wordToGuess);
                break;
            }

            if (!isInputValid(input)) {
                System.out.println("Invalid input. Please enter a single letter.");
                continue;
            }

            char guess = input.charAt(0);

            if (wordToGuess.contains(String.valueOf(guess))) {
                updateGuessedWord(guess);
                if (isGameWon()) {
                    printGameState();
                    System.out.println("You won!");
                    break;
                }
            } else {
                mistakes++;
                printGameState();
                System.out.println("Missed, mistake " + mistakes + " out of " + MAX_MISTAKES + ".");
            }
        }

        if (isGameLost()) {
            printGameState();
            System.out.println("You lost! The word was: " + wordToGuess);
        }
    }

    // Вывод текущего состояния игры
    private void printGameState() {
        System.out.println("\n> The word: " + String.valueOf(guessedWord));
        System.out.println("\n> Missed, mistake " + mistakes + " out of " + MAX_MISTAKES + ".\n");
    }

    public static void main(String[] args) {
        Viselitsa game = new Viselitsa();
        game.play();
    }
}
