
package com.project.weatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;


@Parcel
public class Forecast {

	@SerializedName("forecastday")
	@Expose
	public List<ForecastDay> forecastday = null;

}
