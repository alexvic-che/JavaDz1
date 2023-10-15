package project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ViselitsaTest
{
    private Viselitsa game;
    @BeforeEach
    public  void setUp() {
        game = new Viselitsa();
    }
    @Test
    public void testInvalidWordLength() {
        assertFalse(game.isWordLengthValid("a")); // Слово слишком короткое
        assertTrue(game.isWordLengthValid("test")); // Слово средней длины
        assertFalse(game.isWordLengthValid("verylongworda")); // Слово слишком длинное
    }

    @Test
    public void testGameLoss() {
        int maxMistakes = 3;
        int mistakes = 3;

        assertTrue(game.isGameLost(mistakes, maxMistakes)); // Игра проиграна
    }

    @Test
    public void testGameWin() {
        String wordToGuess = "test";
        char[] guessedWord = {'t', 'e', 's', 't'};

        assertTrue(game.isGameWon(wordToGuess, guessedWord)); // Игра выиграна
    }

    @Test
    public void testInputValidation() {
        String input = "ab";
        assertFalse(game.isInputValid(input)); // Ввод состоит из более чем одной буквы
    }
}
