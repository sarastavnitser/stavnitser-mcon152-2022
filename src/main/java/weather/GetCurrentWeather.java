package weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetCurrentWeather {
    public double getTemperature() throws IOException {
        URL url = new URL("https://samples.openweathermap.org/data/2.5/weather?zip=10019,us&appid=b6907d289e10d714a6e88b30761fae22");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        InputStream in = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line = reader.readLine();
        System.out.println(line);

        return 0;
    }
}
