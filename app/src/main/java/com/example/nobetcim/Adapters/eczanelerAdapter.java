package com.example.nobetcim.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nobetcim.Models.Pharmacy;
import com.example.nobetcim.R;

import java.util.ArrayList;

public class eczanelerAdapter extends RecyclerView.Adapter<eczanelerAdapter.CardViewTasarimTutucuEczane>{

    ArrayList<Pharmacy> eczanelerList;
    Context mContext;

    public eczanelerAdapter(ArrayList<Pharmacy> eczanelerList, Context mContext) {
        this.eczanelerList = eczanelerList;
        this.mContext = mContext;
    }

    public class CardViewTasarimTutucuEczane extends RecyclerView.ViewHolder{
        public CardView cardViewEczane;
        public TextView textViewEczane,textViewTelefon,textViewAdres;

        public CardViewTasarimTutucuEczane(@NonNull View itemView) {
            super(itemView);
            cardViewEczane = itemView.findViewById(R.id.cardViewEczane);
            textViewEczane = itemView.findViewById(R.id.textViewEczane);
            textViewTelefon = itemView.findViewById(R.id.textViewTelefon);
            textViewAdres = itemView.findViewById(R.id.textViewAdres);
        }
    }

    @NonNull
    @Override
    public CardViewTasarimTutucuEczane onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemViewEczane = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_pharmacies,parent,false);
        return new CardViewTasarimTutucuEczane(itemViewEczane);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimTutucuEczane holder, int position) {
        Pharmacy eczane = eczanelerList.get(position);
        holder.textViewEczane.setText(eczane.getName());
        holder.textViewTelefon.setText("Telefon Numarası: " +eczane.getPhone());
        holder.textViewAdres.setText("Adres: "+eczane.getAddress());
    }

    @Override
    public int getItemCount() {
        return eczanelerList.size();
    }


}
