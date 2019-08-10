package com.project.weatherapp.weatherdata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.hannesdorfmann.mosby3.mvp.conductor.MvpController;
import com.project.weatherapp.LandingActivity;
import com.project.weatherapp.R;
import com.project.weatherapp.databinding.ConductorWeatherDataBinding;

public class WeatherReportController extends MvpController<WeatherReportContract.View, WeatherReportPresenter>
		implements WeatherReportContract.View {

	private ConductorWeatherDataBinding binding;

	@NonNull
	@Override
	protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
		binding = DataBindingUtil.inflate(inflater, R.layout.conductor_weather_data, container, false);
		return binding.getRoot();
	}

	@Override
	protected void onAttach(@NonNull View view) {
		super.onAttach(view);
		getPresenter().getWeatherForcastData();
	}

	@NonNull
	@Override
	public WeatherReportPresenter getPresenter() {
		return super.getPresenter();
	}

	@NonNull
	@Override
	public WeatherReportPresenter createPresenter() {
		return LandingActivity.getInstance().getGraphComponent().getWeatherReportPresenter();
	}

	@Override
	public void showLoadingView() {

	}

	@Override
	public void showContentView() {

	}

	@Override
	public void hideLoadingView() {

	}

	@Override
	public void hideContentView() {

	}

	@Override
	public void setContent(String response) {

	}
}
