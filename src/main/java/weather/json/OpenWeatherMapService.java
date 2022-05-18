package weather.json;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapService {
    String APPID = "595db29d1b084794f3e1d715a73ea82b";

    @GET("data/2.5/weather?appid=" + APPID + "&units=imperial")
    Single<CurrentWeather> getCurrentWeather(@Query("q") String zipcode);

}