import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ScrabbleGame {

    private List<String> playedWords = new ArrayList<>();
    private List<Character> tiles = new ArrayList<>();
    private ScrabbleDictionary dictionary = new ScrabbleDictionary();


    public ScrabbleGame() {
        for (int i = 0; i < 7; i++) {
            tiles.add((char) (new Random().nextInt(26) + 'a'));
        }
    }

    public void replenish(){
        while(tiles.size()<7) {
            tiles.add((char) (new Random().nextInt(26) + 'a'));
        }
    }

    /**
     * If the word exists in the ScrabbleDictionary and the letters exist in the tiles List,
     * remove the letters from the list and add new *random* letters.
     *
     * @param word
     */
    public boolean playWord(String word) {
        boolean retVal = false;
        ArrayList<Character> wordsArray = new ArrayList(Collections.singleton(word.toCharArray()));
        for (int i = 0; i < word.length(); i++) {
            if (tiles.contains(wordsArray.get(i))) {
                retVal = true;
            } else {
                retVal = false;
                break;
            }
        }
        if (retVal) {
            if (!dictionary.isWord(word.toUpperCase())) {
                retVal = false;
            }
        }
        if (retVal){
            tiles.removeAll(wordsArray);
            replenish();
        }
        return retVal;
    }

}
