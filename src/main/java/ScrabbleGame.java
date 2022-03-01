import java.util.*;

public class ScrabbleGame {

    private List<String> playedWords = new ArrayList<>();
    private List<Character> tiles = new ArrayList<>();
    private ScrabbleDictionary dictionary;
    private LetterPool letterPool;

    public ScrabbleGame(ScrabbleDictionary dictionary, LetterPool letterPool){
        this.dictionary = dictionary;
        this.letterPool = letterPool;
    }

    public static void main(String[] args) {
        ScrabbleGame s = new ScrabbleGame();
        System.out.println(s.tiles.toString());
        Scanner scanner = new Scanner(System.in);
        System.out.println("word:");
        String word = scanner.next();
        if (!word.equals("")) {
            System.out.println(s.playWord(word));
        }
        System.out.println(s.tiles.toString());
    }

    public ScrabbleGame() {
        for (int i = 0; i < 7; i++) {
            tiles.add((char) (new Random().nextInt(26) + 'a'));
        }
    }

    public void replenish() {
        while (tiles.size() < 7) {
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
//        if (!dictionary.isWord(word)) {
//            return false;
//        }
//
//        char[] characters = word.toUpperCase(Locale.ROOT).toCharArray();
//        for (int i = 0; i < characters.length; i++) {
//            if (!tiles.remove((Character) characters[i])) {
//                return true;
//            }
//        }
//        playedWords.add(word);
//        for (int i = tiles.size(); i < 7; i++) {
//
//        }
//
//        return true;
//    }

        char[] wordsArray = word.toUpperCase().toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (!tiles.contains(wordsArray[i])) {
                return false;
            }
        }

            if (!dictionary.isWord(word)) {
                return  false;
            }


            for (char c : wordsArray) {
                tiles.remove(wordsArray[c]);
            }
            replenish();

        return true;
    }

}
