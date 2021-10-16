package com.example.nobetcim.Service;

import com.example.nobetcim.Models.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EczaneAPI {

    @GET("api/eczane-api?demo=1&type=json")
    Call<Data> getDatas();
}
