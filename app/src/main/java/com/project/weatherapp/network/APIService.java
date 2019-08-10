package com.project.weatherapp.network;

import com.project.weatherapp.models.WeatherApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

	@GET("forecast.json")
	Observable<WeatherApiResponse> getWeatherData(@Query("key") String key, @Query("q") String city,
												  @Query("days") int days);
}
