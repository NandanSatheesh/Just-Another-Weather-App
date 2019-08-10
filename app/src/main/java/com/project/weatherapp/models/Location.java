
package com.project.weatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel
public class Location {

	@SerializedName("name")
	@Expose
	public String name;
	@SerializedName("region")
	@Expose
	public String region;
	@SerializedName("country")
	@Expose
	public String country;
	@SerializedName("lat")
	@Expose
	public double lat;
	@SerializedName("lon")
	@Expose
	public double lon;
	@SerializedName("tz_id")
	@Expose
	public String tzId;
	@SerializedName("localtime_epoch")
	@Expose
	public long localtimeEpoch;
	@SerializedName("localtime")
	@Expose
	public String localtime;

}
