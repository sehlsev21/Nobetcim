package com.example.nobetcim.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Datum implements Serializable {

    @SerializedName("CityID")
    @Expose
    private String cityID;

    @SerializedName("CityName")
    @Expose
    private String cityName;

    @SerializedName("countPharmacy")
    @Expose
    private String countPharmacy;

    @SerializedName("area")
    @Expose
    private List<Area> area;





    public String getCityID() {
        return cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountPharmacy() {
        return countPharmacy;
    }

    public List<Area> getArea() {
        return area;
    }







}
