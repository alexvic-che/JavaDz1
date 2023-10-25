package project1;

import java.util.Random;
import java.util.Scanner;

public class Viselitsa {
    private static final String[] WORDS = {"hello", "world", "java", "programming", "hangman"};
    private static final int MAX_MISTAKES = 5;

    // Проверка, что длина слова находится в допустимом диапазоне
    public boolean isWordLengthValid(String word) {
        return word.length() >= 3 && word.length() <= 12;
    }

    // Проверка, проиграна ли игра
    public boolean isGameLost(int mistakes, int maxMistakes) {
        return mistakes >= maxMistakes;
    }

    // Проверка, выиграна ли игра
    public boolean isGameWon(String word, char[] guessedWord) {
        return String.valueOf(guessedWord).equals(word);
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
    private static void updateGuessedWord(String word, char[] guessedWord, char guess) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                guessedWord[i] = guess;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = getRandomWord(WORDS);
        char[] guessedWord = new char[wordToGuess.length()];
        int mistakes = 0;

        // Заполняем массив символами '*', чтобы скрыть слово
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord[i] = '*';
        }

        System.out.println("Welcome to Viselitsa!");
        printGameState(guessedWord, mistakes);

        while (mistakes < MAX_MISTAKES) {
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
                updateGuessedWord(wordToGuess, guessedWord, guess);
                if (String.valueOf(guessedWord).equals(wordToGuess)) {
                    printGameState(guessedWord, mistakes);
                    System.out.println("You won!");
                    break;
                }
            } else {
                mistakes++;
                printGameState(guessedWord, mistakes);
                System.out.println("Missed, mistake " + mistakes + " out of " + MAX_MISTAKES + ".");
            }
        }

        if (mistakes == MAX_MISTAKES) {
            printGameState(guessedWord, mistakes);
            System.out.println("You lost! The word was: " + wordToGuess);
        }
    }

    // Вывод текущего состояния игры
    private static void printGameState(char[] guessedWord, int mistakes) {
        System.out.println("\n> The word: " + String.valueOf(guessedWord));
        System.out.println("\n> Missed, mistake " + mistakes + " out of " + MAX_MISTAKES + ".\n");
    }
}

