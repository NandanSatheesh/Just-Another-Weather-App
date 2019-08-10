
package com.project.weatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel
public class Current {

	@SerializedName("last_updated_epoch")
	@Expose
	public long lastUpdatedEpoch;
	@SerializedName("last_updated")
	@Expose
	public String lastUpdated;
	@SerializedName("temp_c")
	@Expose
	public double tempC;
	@SerializedName("temp_f")
	@Expose
	public double tempF;
	@SerializedName("is_day")
	@Expose
	public long isDay;
	@SerializedName("condition")
	@Expose
	public Condition condition;
	@SerializedName("wind_mph")
	@Expose
	public double windMph;
	@SerializedName("wind_kph")
	@Expose
	public double windKph;
	@SerializedName("wind_degree")
	@Expose
	public long windDegree;
	@SerializedName("wind_dir")
	@Expose
	public String windDir;
	@SerializedName("pressure_mb")
	@Expose
	public double pressureMb;
	@SerializedName("pressure_in")
	@Expose
	public double pressureIn;
	@SerializedName("precip_mm")
	@Expose
	public double precipMm;
	@SerializedName("precip_in")
	@Expose
	public double precipIn;
	@SerializedName("humidity")
	@Expose
	public long humidity;
	@SerializedName("cloud")
	@Expose
	public long cloud;
	@SerializedName("feelslike_c")
	@Expose
	public double feelslikeC;
	@SerializedName("feelslike_f")
	@Expose
	public double feelslikeF;
	@SerializedName("vis_km")
	@Expose
	public double visKm;
	@SerializedName("vis_miles")
	@Expose
	public double visMiles;
	@SerializedName("uv")
	@Expose
	public double uv;

}
