import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ScrabbleFrame extends JFrame {

    private int score = 0;
    private JLabel scoreLabel;
    private JPanel tilesPanel;
    private JLabel[] tiles;
    private ScrabbleGame scrabbleGame;
    private JTextField inputField;
    private JLabel errorMessageLabel;

    public ScrabbleFrame() {
        setTitle("Touro Scrabble");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        ScrabbleDictionary dictionary = new ScrabbleDictionary();
        LetterPool letterPool = new LetterPool();
        scrabbleGame = new ScrabbleGame(dictionary, letterPool);


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
            tiles[i] = new JLabel(scrabbleGame.tiles.get(i).toString());
            tiles[i].setBorder(BorderFactory.createLineBorder(Color.black));
            tilesPanel.add(tiles[i]);
        }
        verticalPanel.add(tilesPanel);
    }

    public void onSubmitClicked(ActionEvent actionEvent) {
        String word = inputField.getText();
        if (scrabbleGame.playWord(word).equals("TRUE")) {
            score++;
            scoreLabel.setText(String.valueOf(score));

            for (int i = 0; i < tiles.length; i++) {
                tiles[i].setText((scrabbleGame.tiles.get(i).toString()));

            }
        } else {
            errorMessageLabel.setText(scrabbleGame.playWord(word));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new ScrabbleFrame();
        frame.setVisible(true);
    }
}
