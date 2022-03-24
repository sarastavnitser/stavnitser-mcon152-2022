import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ScrabbleFrame extends JFrame {

    private final ScrabblePresenter presenter;


    //    private int score = 0;
    private JLabel scoreLabel;
    private JPanel tilesPanel;
    private JLabel[] tiles;
//    private ScrabbleGame scrabbleGame;
    private JTextField inputField;
    private JLabel errorMessageLabel;

    public ScrabbleFrame() {
        setTitle("Touro Scrabble");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());



        ScrabbleDictionary dictionary = new ScrabbleDictionary();
        LetterPool letterPool = new LetterPool();
        ScrabbleGame scrabbleGame = new ScrabbleGame(dictionary, letterPool);

        presenter = new ScrabblePresenter(this, scrabbleGame);

        JPanel verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        add(verticalPanel);

        addTilesPanel(verticalPanel);

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(120, 60));
        add(inputField);

        scoreLabel = new JLabel("2000");
        verticalPanel.add(scoreLabel);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.addActionListener(this::onSubmitClicked);
        verticalPanel.add(submitButton);

        JLabel outputLabel = new JLabel("OUTPUT");
        verticalPanel.add(outputLabel);

        errorMessageLabel = new JLabel();
        add(errorMessageLabel);
    }

    private void addTilesPanel(JPanel verticalPanel) {
        tilesPanel = new JPanel();
        tilesPanel.setLayout(new FlowLayout());

        tiles = new JLabel[7];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new JLabel();
            tiles[i].setBorder(BorderFactory.createLineBorder(Color.black));
            tilesPanel.add(tiles[i]);
        }
        verticalPanel.add(tilesPanel);
        presenter.fillTiles();
    }

    public void onSubmitClicked(ActionEvent actionEvent) {
        String word = inputField.getText();
        presenter.playWord(word);

    }
    public void setScore(String score) {
        scoreLabel.setText(score);
    }
    public void setErrorMessageLabel(String error){
        errorMessageLabel.setText(error);
    }

    public void setTiles(List<Character> tilesList){
        for(int i = 0; i<tilesList.size(); i++){
            tiles[i].setText(tilesList.get(i).toString());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new ScrabbleFrame();
        frame.setVisible(true);
    }


}
