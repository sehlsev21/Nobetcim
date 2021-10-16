package com.example.nobetcim.Activities;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nobetcim.Models.Data;
import com.example.nobetcim.Models.Datum;
import com.example.nobetcim.R;
import com.example.nobetcim.Service.EczaneAPI;
import com.example.nobetcim.Adapters.sehirAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class MainActivity extends AppCompatActivity {

    ArrayList<Datum> veriler;
    private String BASE_URL = "https://eczaneleri.net/";
    Retrofit retrofit;
    RecyclerView recyclerViewSehirler;
    private sehirAdapter adapter;
    private Toolbar toolbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-------------------------->
        toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);


        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        loadData();

        recyclerViewSehirler = findViewById(R.id.recyclerViewSehirler);

    }

    private void loadData(){

        EczaneAPI eczaneAPI = retrofit.create(EczaneAPI.class);
        Call<Data> call = eczaneAPI.getDatas();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if(response.isSuccessful()){
                    ArrayList<Datum> responseList = new ArrayList<>(response.body().getData());
                    veriler = responseList;

                    recyclerViewSehirler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    adapter = new sehirAdapter(veriler,MainActivity.this);
                    recyclerViewSehirler.setAdapter(adapter);

                    /* for(int i = 0; i< veriler.size(); i++){
                        System.out.println("***IL ADI: " + veriler.get(i).getCityName());

                        for (int j = 0; j< veriler.get(i).getArea().size(); j++) {
                            System.out.println("ILCE ADI: " + veriler.get(i).getArea().get(j).getAreaName());

                            if (veriler.get(i).getArea().get(j).getPharmacy() != null) {
                                for (int k = 0; k < veriler.get(i).getArea().get(j).getPharmacy().size(); k++) {
                                    System.out.println("ECZANE ADI: " + veriler.get(i).getArea().get(j).getPharmacy().get(k).getName());
                                }
                            }
                        }
                    }*/


                }

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                t.printStackTrace();
            }
        });



    }


}