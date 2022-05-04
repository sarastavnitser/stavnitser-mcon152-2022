package weather;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class CurrentWeatherFrame extends JFrame {

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
    }

    private void onSubmitClicked(ActionEvent actionEvent) {
        Observable<CurrentWeather> observable = getCurrentWeather.getCurrentWeather(zipcodeInputField.getText());

        Disposable disposable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(this::onNext, this::onError);
    }

    public void onNext(CurrentWeather currentWeather) {
        double fahrenheit = currentWeather.getTemperature();
        tempLabel.setText(String.valueOf(fahrenheit));
    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    public static void main(String[] args) {
        JFrame frame = new CurrentWeatherFrame();
        frame.setVisible(true);
    }


}
