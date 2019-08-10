package com.project.weatherapp.dagger;


import com.project.weatherapp.weatherdata.WeatherReportPresenter;

public interface ModuleComponent {
	WeatherReportPresenter getWeatherReportPresenter();
}
