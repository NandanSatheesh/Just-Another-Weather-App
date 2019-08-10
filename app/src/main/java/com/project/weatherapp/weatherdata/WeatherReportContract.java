package com.project.weatherapp.weatherdata;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.project.weatherapp.models.WeatherApiResponse;

public interface WeatherReportContract {

	interface View extends MvpView {

		void showLoadingView();

		void showContentView();

		void hideLoadingView();

		void hideContentView();

		void setContent(WeatherApiResponse response);

	}

	interface Presenter extends MvpPresenter<View> {

	}
}
