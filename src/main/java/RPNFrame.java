import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class RPNFrame extends JFrame {

    private JTextField inputField;
    private RPN rpn;
    private JLabel directions;
    private JLabel resultLabelTitle;
    private JLabel resultLabel;
    private ArrayList<String> expressions = new ArrayList<>();
    private ArrayList<String> results = new ArrayList<>();
    private JList<String> expressionsList;
    private JList<String> resultsList;
    private JScrollPane expressionsPane;
    private JScrollPane resultsPane;

    public RPNFrame() {
        setTitle("RPN");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        rpn = new RPN();




        JPanel verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        add(verticalPanel);

        directions = new JLabel("Enter an RPN expression:");
        verticalPanel.add(directions);

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(120, 30));
        verticalPanel.add(inputField);


        JButton calculateButton = new JButton("CALCULATE");
        calculateButton.addActionListener(this::onCalculateClicked);
        verticalPanel.add(calculateButton);

        resultLabelTitle = new JLabel("Result:");
        verticalPanel.add(resultLabelTitle);

        resultLabel = new JLabel();
        verticalPanel.add(resultLabel);


    }

    private void onCalculateClicked(ActionEvent actionEvent) {
        String elements = inputField.getText().trim();
        expressions.add(elements);
        String result = rpn.findRPNResult(elements);
        results.add(result);
        resultLabel.setText(result);

    }

    public static void main(String[] args) {
        JFrame frame = new RPNFrame();
        frame.setVisible(true);

    }
}
