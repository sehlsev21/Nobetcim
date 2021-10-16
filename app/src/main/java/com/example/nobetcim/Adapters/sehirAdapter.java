package com.example.nobetcim.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nobetcim.Activities.MainActivity2;
import com.example.nobetcim.Models.Area;
import com.example.nobetcim.Models.Datum;
import com.example.nobetcim.R;

import java.util.ArrayList;

public class sehirAdapter extends RecyclerView.Adapter<sehirAdapter.CardViewTasarimTutucuSehir>  {
    private ArrayList<Datum> sehirlerList;
    private Context mContext;

    public sehirAdapter(ArrayList<Datum> sehirlerList, Context mContext) {
        this.sehirlerList = sehirlerList;
        this.mContext = mContext;
    }

    public class CardViewTasarimTutucuSehir extends RecyclerView.ViewHolder{
        public CardView cardViewSehir;
        public TextView textViewSehir,textViewEczaneSayisi;
        public CardViewTasarimTutucuSehir(View view){
            super(view);
            cardViewSehir = view.findViewById(R.id.cardViewSehir);
            textViewSehir = view.findViewById(R.id.textViewSehir);
            textViewEczaneSayisi = view.findViewById(R.id.textViewEczaneSayisi);
        }
    }

    @NonNull
    @Override
    public CardViewTasarimTutucuSehir onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemViewSehir = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_city,parent,false);
        return new CardViewTasarimTutucuSehir(itemViewSehir);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimTutucuSehir holder, int position) {

        Datum sehirler = sehirlerList.get(position);
        ArrayList<Area> ilceler = (ArrayList<Area>) sehirlerList.get(position).getArea();

        holder.textViewSehir.setText(sehirler.getCityID() + " - " + sehirler.getCityName());
        holder.textViewEczaneSayisi.setText("İldeki Top. Nöbetçi Eczane Sayısı: " + sehirler.getCountPharmacy());
        holder.cardViewSehir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("sehirlerArray",ilceler);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return sehirlerList.size();
    }
}
