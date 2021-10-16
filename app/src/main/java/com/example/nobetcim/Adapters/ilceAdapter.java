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

import com.example.nobetcim.Activities.MainActivity3;
import com.example.nobetcim.Models.Area;
import com.example.nobetcim.Models.Pharmacy;
import com.example.nobetcim.R;

import java.util.ArrayList;

public class ilceAdapter extends RecyclerView.Adapter<ilceAdapter.CardViewTasarimTutucuIlce>{

    private ArrayList<Area> ilcelerList;
    private Context mContext;


    public ilceAdapter(ArrayList<Area> ilcelerList, Context mContext) {
        this.ilcelerList = ilcelerList;
        this.mContext = mContext;
    }

    public class CardViewTasarimTutucuIlce extends RecyclerView.ViewHolder {
        public CardView cardViewIlce;
        public TextView textViewIlce,textViewEczaneSayisi2;


        public CardViewTasarimTutucuIlce(@NonNull View itemView) {
            super(itemView);
            cardViewIlce = itemView.findViewById(R.id.cardViewIlce);
            textViewIlce = itemView.findViewById(R.id.textViewIlce);
            textViewEczaneSayisi2 = itemView.findViewById(R.id.textViewEczaneSayisi2);
        }
    }

    @NonNull
    @Override
    public CardViewTasarimTutucuIlce onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemViewIlce = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_area,parent,false);
        return new CardViewTasarimTutucuIlce(itemViewIlce);

    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimTutucuIlce holder, int position) {
        Area ilce = ilcelerList.get(position);
        ArrayList<Pharmacy> eczaneler = (ArrayList<Pharmacy>) ilcelerList.get(position).getPharmacy();
        holder.textViewIlce.setText(ilce.getAreaName());
        holder.textViewEczaneSayisi2.setText("İlçedeki Top. Nöbetçi Eczane Sayısı: " +ilce.getCountPharmacy());
        holder.cardViewIlce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MainActivity3.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("ilcelerArray",eczaneler);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ilcelerList.size();
    }


}
