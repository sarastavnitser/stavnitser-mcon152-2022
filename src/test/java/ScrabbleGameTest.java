import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleGameTest {

    ScrabbleDictionary dictionary = Mockito.mock(ScrabbleDictionary.class);
    LetterPool letterPool = Mockito.mock(LetterPool.class);

    @Test
    public void playWord_true() {
        // given
        Mockito.doReturn(true)
                .when(dictionary)
                .isWord("HELLO");
        Mockito.doReturn('A','H','E','L','L','O','G')
                .when(letterPool)
                .getRandomLetter();
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);

        // when

        // then
        assertEquals(game.getStrTrue(), game.playWord("HELLO"));
        Mockito.verify(letterPool, Mockito.times(7+5))
                .getRandomLetter();
        assertTrue(game.playedWords.contains("HELLO"));
        assertEquals(1, game.playedWords.size());
        assertEquals(7, game.tiles.size());
    }

    @Test
    public void playWord_false() {
        // given
        Mockito.doReturn(true)
                .when(dictionary)
                .isWord("LOGO");
        Mockito.doReturn('A','H','E','L','L','O','G')
                .when(letterPool)
                .getRandomLetter();
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);

        // when

        // then
        assertEquals(game.getNotInTiles(), game.playWord("LOGO"));
        assertTrue(game.playedWords.isEmpty());
        Mockito.verify(letterPool, Mockito.times(7))
                .getRandomLetter();
        assertEquals(7, game.tiles.size());
    }

    @Test
    public void playWord_notInDictionary() {
        // given
        Mockito.doReturn('A','H','E','L','L','O','G')
                .when(letterPool)
                .getRandomLetter();
        ScrabbleGame game = new ScrabbleGame(dictionary, letterPool);

        // when
        String val = game.playWord("HEL");

        // then
        Mockito.verify(dictionary)
                .isWord("HEL");
        assertEquals(game.getNotAWord(), val);
        assertTrue(game.playedWords.isEmpty());
    }

}