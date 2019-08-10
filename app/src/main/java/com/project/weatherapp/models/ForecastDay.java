
package com.project.weatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel
public class ForecastDay {

	@SerializedName("date")
	@Expose
	public String date;
	@SerializedName("date_epoch")
	@Expose
	public long dateEpoch;
	@SerializedName("day")
	@Expose
	public Day day;
	@SerializedName("astro")
	@Expose
	public Astro astro;

}
