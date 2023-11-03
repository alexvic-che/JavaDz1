package project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ViselitsaTest
{
    private Viselitsa game;

    @BeforeEach
    void setUp() {
        game = new Viselitsa();
    }

    @Test
    void isWordLengthValid_ValidLength_ReturnsTrue() {
        assertTrue(game.isWordLengthValid("hello"));
    }

    @Test
    void isWordLengthValid_TooShort_ReturnsFalse() {
        assertFalse(game.isWordLengthValid("hi"));
    }

    @Test
    void isWordLengthValid_TooLong_ReturnsFalse() {
        assertFalse(game.isWordLengthValid("programminglanguage"));
    }



    @Test
    void isInputValid_ValidInput_ReturnsTrue() {
        assertTrue(Viselitsa.isInputValid("a"));
    }

    @Test
    void isInputValid_InvalidInput_ReturnsFalse() {
        assertFalse(Viselitsa.isInputValid("ab"));
    }

    @Test
    void getRandomWord_ReturnsRandomWordFromDictionary() {
        String[] words = {"hello", "world", "java", "programming", "hangman"};
        String randomWord = Viselitsa.getRandomWord(words);
        assertTrue(randomWord.equals("hello") || randomWord.equals("world") ||
            randomWord.equals("java") || randomWord.equals("programming") ||
            randomWord.equals("hangman"));
    }


}
