package com.example.nobetcim.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Area implements Serializable {

        @SerializedName("areaName")
        @Expose
        private String areaName;

        @SerializedName("countPharmacy")
        @Expose
        private String countPharmacy;

        @SerializedName("pharmacy")
        @Expose
        private List<Pharmacy> pharmacy;



        public String getAreaName() {
            return areaName;
        }

        public String getCountPharmacy() {
            return countPharmacy;
        }

        public List<Pharmacy> getPharmacy() {
            return pharmacy;
        }



    }
