package com.example.recyclerviewcardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcardview.R;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.tituloFilme.setText(" titulo");
            holder.generoFilme.setText(String.valueOf("Teste genero"));
            holder.anoFilme.setText(String.valueOf("Teste ano"));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tituloFilme;
        TextView generoFilme;
        TextView anoFilme;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);
            tituloFilme =  (TextView) itemView.findViewById(R.id.textViewTitulo);
            generoFilme = (TextView)itemView.findViewById(R.id.textViewGenero);
            anoFilme =  (TextView)  itemView.findViewById(R.id.textViewAno);
        }
    }

}


