
package com.project.weatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel
public class Day {

	@SerializedName("maxtemp_c")
	@Expose
	public double maxtempC;
	@SerializedName("maxtemp_f")
	@Expose
	public double maxtempF;
	@SerializedName("mintemp_c")
	@Expose
	public double mintempC;
	@SerializedName("mintemp_f")
	@Expose
	public double mintempF;
	@SerializedName("avgtemp_c")
	@Expose
	public double avgtempC;
	@SerializedName("avgtemp_f")
	@Expose
	public double avgtempF;
	@SerializedName("maxwind_mph")
	@Expose
	public double maxwindMph;
	@SerializedName("maxwind_kph")
	@Expose
	public double maxwindKph;
	@SerializedName("totalprecip_mm")
	@Expose
	public double totalprecipMm;
	@SerializedName("totalprecip_in")
	@Expose
	public double totalprecipIn;
	@SerializedName("avgvis_km")
	@Expose
	public double avgvisKm;
	@SerializedName("avgvis_miles")
	@Expose
	public double avgvisMiles;
	@SerializedName("avghumidity")
	@Expose
	public double avghumidity;
	@SerializedName("condition")
	@Expose
	public ConditionData condition;
	@SerializedName("uv")
	@Expose
	public double uv;

}
