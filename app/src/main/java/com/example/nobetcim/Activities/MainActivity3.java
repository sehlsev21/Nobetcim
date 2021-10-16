package com.example.nobetcim.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nobetcim.Models.Pharmacy;
import com.example.nobetcim.R;
import com.example.nobetcim.Adapters.eczanelerAdapter;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    RecyclerView recyclerViewEczaneler;
    private eczanelerAdapter adapter;
    private ArrayList<Pharmacy> eczaneler;
    private Toolbar toolbar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        toolbar3 = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar3);

        recyclerViewEczaneler = findViewById(R.id.recyclerViewEczaneler);
        eczaneler = new ArrayList<>();

        Bundle bundleObject = getIntent().getExtras();
        eczaneler = (ArrayList<Pharmacy>) bundleObject.getSerializable("ilcelerArray");

        recyclerViewEczaneler.setLayoutManager(new LinearLayoutManager(MainActivity3.this));
        adapter = new eczanelerAdapter(eczaneler,MainActivity3.this);
        recyclerViewEczaneler.setAdapter(adapter);
    }
}