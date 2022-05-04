package weather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CurrentWeatherFrame extends JFrame {

    private  CurrentWeatherPresenter presenter;
    private JTextField zipcodeInputField;
    private JButton submitButton;
    private JLabel tempLabel;
    private GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

    public CurrentWeatherFrame() {

        setTitle("Current Weather");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        zipcodeInputField = new JTextField("Enter zipcode here");
        submitButton = new JButton("SUBMIT");

        submitButton.addActionListener(this::onSubmitClicked);

        tempLabel = new JLabel();

        add(zipcodeInputField);
        add(submitButton);
        add(tempLabel);

        presenter = new CurrentWeatherPresenter(this, new GetCurrentWeather());
    }

    private void onSubmitClicked(ActionEvent actionEvent) {
        presenter.loadWeatherFromZipcode(zipcodeInputField.getText());
    }





    public static void main(String[] args) {
        JFrame frame = new CurrentWeatherFrame();
        frame.setVisible(true);
    }
    public void setTemperature(double temperature){
        tempLabel.setText(String.valueOf(temperature));
    }


}
