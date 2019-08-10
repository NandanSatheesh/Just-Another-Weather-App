
package com.project.weatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Condition {

	@SerializedName("text")
	@Expose
	public String text;
	@SerializedName("icon")
	@Expose
	public String icon;
	@SerializedName("code")
	@Expose
	public long code;

}
