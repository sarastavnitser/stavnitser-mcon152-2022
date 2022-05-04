package weather;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;

public class CurrentWeatherPresenter {
    private final CurrentWeatherFrame view;
    private final GetCurrentWeather model;
    private Disposable disposable;

    public CurrentWeatherPresenter(CurrentWeatherFrame view, GetCurrentWeather model){
        this.view = view;
        this.model = model;
    }

    public void loadWeatherFromZipcode(String zipcode){
        // disposable is used to cancel the request.
        disposable = model.getCurrentWeather(zipcode)
                //do this request in the background
                .subscribeOn(Schedulers.io())
                //run onNext in a new thread
                .observeOn(Schedulers.newThread())
                .subscribe(this::onNext, this::onError);


    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    public  void cancel(){
        if(disposable != null){
            disposable.dispose();
        }
    }

    public void onNext(CurrentWeather currentWeather) {
        double fahrenheit = currentWeather.getTemperature();
        view.setTemperature(fahrenheit);
    }
}
