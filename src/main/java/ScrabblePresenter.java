import java.util.List;

public class ScrabblePresenter {
    private final ScrabbleFrame view;
    private final ScrabbleGame model;
    private int score;

    public ScrabblePresenter(ScrabbleFrame view, ScrabbleGame model){
        this.view = view;
        this.model = model;
    }

    public void playWord(String word){
        if (model.playWord(word).equals(model.getStrTrue())) {
            score++;
            view.setScore(String.valueOf(score));
            view.setTiles(model.getTiles());

        } else {
            view.setErrorMessageLabel(model.playWord(word));
        }
    }
    public void fillTiles(){
        List<Character> tiles = model.getTiles();
        view.setTiles(tiles);
    }
}
