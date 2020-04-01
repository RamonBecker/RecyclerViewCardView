package com.example.recyclerviewcardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcardview.R;
import com.example.recyclerviewcardview.adapter.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Filme> listaFilme;

    public Adapter(List<Filme> lista) {
        this.listaFilme = lista;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new MyViewHolder(itemLista);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Filme filme = listaFilme.get(position);

        holder.tituloFilme.setText(filme.getNome());
        holder.generoFilme.setText(filme.getGenero());
        holder.anoFilme.setText(String.valueOf(filme.getAno()));
        holder.descricaoFilme.setText(filme.getDescricao());
        holder.imgFilme.setImageResource(filme.getIdImagem());
    }

    @Override
    public int getItemCount() {
        return listaFilme.size();
    }

    /*
    private List<Filme> listaFilme;

    public Adapter(List<Filme> lista) {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Filme filme = listaFilme.get(position);

        holder.tituloFilme.setText(filme.getNome());
        holder.generoFilme.setText(filme.getGenero());
        holder.anoFilme.setText(String.valueOf(filme.getAno()));
    }

    @Override
    public int getItemCount() {
        return listaFilme.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tituloFilme;
        private TextView generoFilme;
        private TextView anoFilme;
        private TextView descricaoFilme;
        private ImageView imgFilme;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
         //   itemView.setTag(this);

            tituloFilme = (TextView) itemView.findViewById(R.id.textViewtitulo);
            generoFilme = (TextView) itemView.findViewById(R.id.textViewGenero);
            descricaoFilme = (TextView) itemView.findViewById(R.id.textViewDescricao)
            anoFilme = (TextView) itemView.findViewById(R.id.textViewAno);
           // imgFilme = (ImageView) itemView.findViewById(R.id.imageViewFilme);

        }
    }


     */

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tituloFilme;
        private TextView generoFilme;
        private TextView anoFilme;
        private TextView descricaoFilme;
        private ImageView imgFilme;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloFilme = (TextView) itemView.findViewById(R.id.textViewtitulo);
            generoFilme = (TextView) itemView.findViewById(R.id.textViewGenero);
            descricaoFilme = (TextView) itemView.findViewById(R.id.textViewDescricao);
            anoFilme = (TextView) itemView.findViewById(R.id.textViewAno);
            imgFilme = (ImageView) itemView.findViewById(R.id.imageViewFilme);
        }
    }


}


