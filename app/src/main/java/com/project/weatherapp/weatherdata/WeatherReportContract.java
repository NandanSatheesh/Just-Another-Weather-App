package com.project.weatherapp.weatherdata;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface WeatherReportContract {

	interface View extends MvpView {

		void showLoadingView();

		void showContentView();

		void hideLoadingView();

		void hideContentView();

		void setContent(String response);

	}

	interface Presenter extends MvpPresenter<View> {

	}
}
