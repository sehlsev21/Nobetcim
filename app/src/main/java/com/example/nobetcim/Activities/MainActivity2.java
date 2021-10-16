package com.example.nobetcim.Activities;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nobetcim.Models.Area;
import com.example.nobetcim.R;
import com.example.nobetcim.Adapters.ilceAdapter;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerViewIlceler;
    private ilceAdapter adapter;
    private ArrayList<Area> ilceler;
    private Toolbar toolbar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);

        recyclerViewIlceler = findViewById(R.id.recyclerViewIlceler);
        ilceler = new ArrayList<>();

        Bundle bundleObject = getIntent().getExtras();
        ilceler = (ArrayList<Area>) bundleObject.getSerializable("sehirlerArray");



        recyclerViewIlceler.setLayoutManager(new LinearLayoutManager(MainActivity2.this));
        adapter = new ilceAdapter(ilceler,MainActivity2.this);
        recyclerViewIlceler.setAdapter(adapter);




    }
}