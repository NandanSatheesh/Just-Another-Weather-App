package com.project.weatherapp.weatherdata;

import com.project.weatherapp.models.WeatherApiResponse;
import com.project.weatherapp.network.APIService;
import com.project.weatherapp.network.NetworkUtil;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WeatherReportPresenter implements WeatherReportContract.Presenter {

	private CompositeDisposable compositeDisposable;
	private APIService service;

	@Inject
	public WeatherReportPresenter(APIService service) {
		this.service = service;
		compositeDisposable = new CompositeDisposable();
	}

	public void getWeatherForcastData() {
		service.getWeatherData(NetworkUtil.API_KEY, "Bangalore", 4)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<WeatherApiResponse>() {
					@Override
					public void onSubscribe(Disposable d) {
						compositeDisposable.add(d);
					}

					@Override
					public void onNext(WeatherApiResponse weatherApiResponse) {


					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onComplete() {
						compositeDisposable.clear();
					}
				});
	}


	@Override
	public void attachView(WeatherReportContract.View view) {

	}

	@Override
	public void detachView(boolean retainInstance) {

	}

	@Override
	public void detachView() {

	}

	@Override
	public void destroy() {

	}
}
