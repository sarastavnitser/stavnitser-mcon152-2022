import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.DataInput;
import java.util.Dictionary;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleGameTest {

    @Test
    void playWord_true() {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();
        LetterPool letterPool = Mockito.mock(LetterPool.class);
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);
        Mockito.doReturn('H', 'E', 'L', 'L', 'O', 'F', 'G').when(letterPool).getRandomLetter();

//        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);

        // when

        //then
        assertTrue((game.playWord("HELLO")));

    }
    @Test
    void playWord_false() {
        // given
        ScrabbleDictionary dictionary = Mockito.mock(ScrabbleDictionary.class);
        LetterPool letterPool = Mockito.mock(LetterPool.class);
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);
        Mockito.doReturn('H', 'E', 'L', 'L', 'O', 'F', 'G').when(letterPool).getRandomLetter();

//        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);

        // when

        //then
        assertFalse((game.playWord("WORLD")));

    }
    @Test
    void playWord_notInDictionary() {
        // given
        ScrabbleDictionary dictionary = new ScrabbleDictionary();
        LetterPool letterPool = Mockito.mock(LetterPool.class);
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);
        Mockito.doReturn('H', 'E', 'L', 'L', 'O', 'F', 'G').when(letterPool).getRandomLetter();

//        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);

        // when

        //then
        assertFalse((game.playWord("HEL")));

    }
}