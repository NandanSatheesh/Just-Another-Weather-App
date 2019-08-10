
package com.project.weatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel
public class WeatherApiResponse {

	@SerializedName("location")
	@Expose
	public Location location;
	@SerializedName("current")
	@Expose
	public Current current;
	@SerializedName("forecast")
	@Expose
	public Forecast forecast;

}
