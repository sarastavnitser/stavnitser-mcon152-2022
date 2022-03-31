package weather;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GetCurrentWeatherTest {
    @Test
    void GetCurrentWeather() throws IOException {
        //given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

        //when
        double temp = getCurrentWeather.getTemperature();

        //then
        assertTrue(temp>0);
    }

}