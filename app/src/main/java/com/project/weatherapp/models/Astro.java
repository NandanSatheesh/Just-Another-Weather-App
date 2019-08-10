
package com.project.weatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Astro {

    @SerializedName("sunrise")
    @Expose
    public String sunrise;
    @SerializedName("sunset")
    @Expose
    public String sunset;
    @SerializedName("moonrise")
    @Expose
    public String moonrise;
    @SerializedName("moonset")
    @Expose
    public String moonset;

}
