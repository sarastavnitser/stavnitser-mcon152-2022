import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ScrabbleGame {

    List<String> playedWords = new ArrayList<>();
    List<Character> tiles = new ArrayList<>();
    private ScrabbleDictionary dictionary;
    private LetterPool letterPool;
    private static final String notAWord = "NOT A WORD";
    private static final String strTrue = "TRUE";
    private static final String notInTiles = "NOT IN TILES";

    public ScrabbleGame(
            ScrabbleDictionary dictionary,
            LetterPool letterPool
    ) {
        this.dictionary = dictionary;
        this.letterPool = letterPool;
        for (int i = 0; i < 7; i++) {
            tiles.add(letterPool.getRandomLetter());
        }
    }

    /**
     * If the word exists in the ScrabbleDictionary and the letters exist in the tiles List,
     * remove the letters from the list and add new *random* letters.
     *
     * @param word
     */
    public String playWord(String word) {
        if (!dictionary.isWord(word)) {
            return notAWord;
        }

        char[] characters = word.toUpperCase(Locale.ROOT).toCharArray();
        List<Character> temp = new ArrayList<>(tiles);
        for (char character : characters) {
            if (!temp.remove((Character) character)) {
                return notInTiles;
            }
        }
        tiles = temp;

        playedWords.add(word);

        for (int i = tiles.size(); i < 7; i++) {
            tiles.add(letterPool.getRandomLetter());
        }
        return strTrue;
    }
    public String getNotAWord(){
        return notAWord;
    }
    public String getStrTrue(){
        return strTrue;
    }
    public String getNotInTiles(){
        return notInTiles;
    }

}




