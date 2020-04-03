package com.example.recyclerviewcardview.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcardview.R;
import com.example.recyclerviewcardview.activity.EditarFilme;
import com.example.recyclerviewcardview.activity.MainActivity;
import com.example.recyclerviewcardview.adapter.model.Filme;
import com.example.recyclerviewcardview.controller.ControllerFIlme;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
  //  private List<Filme> listaFilme;
    private ControllerFIlme controllerFIlme;
    AppCompatActivity activity;
   private LayoutInflater layoutInflater;

    public Adapter(Context context, AppCompatActivity activity) {
        this.layoutInflater = LayoutInflater.from(context);
        this.activity = activity;
        this.controllerFIlme = ControllerFIlme.getInstance();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = layoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new MyViewHolder(itemLista);

    }

    public void mover(int fromPosition, int toPosition){

        if(fromPosition < toPosition){
            for (int i = fromPosition; i < toPosition; i++){
               Collections.swap(controllerFIlme.getListaFilme(), i, i+1);
            }
        }else{
            for (int i = fromPosition; i > toPosition; i--){
                Collections.swap(controllerFIlme.getListaFilme(), i, i - 1);
            }

            notifyItemMoved(fromPosition, toPosition);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Filme filme = controllerFIlme.getListaFilme().get(position);

        holder.tituloFilme.setText(filme.getNome());
        holder.generoFilme.setText(filme.getGenero());
        holder.anoFilme.setText(String.valueOf(filme.getAno()));
        holder.descricaoFilme.setText(filme.getDescricao());
        holder.imgFilme.setImageResource(filme.getIdImagem());
        holder.posicaoFilme.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return controllerFIlme.getListaFilme().size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tituloFilme;
        private TextView generoFilme;
        private TextView anoFilme;
        private TextView descricaoFilme;
        private ImageView imgFilme;
        private TextView posicaoFilme;


        public MyViewHolder(@NonNull View itemView) {


            super(itemView);
            tituloFilme = (TextView) itemView.findViewById(R.id.textViewtitulo);
            generoFilme = (TextView) itemView.findViewById(R.id.textViewGenero);
            descricaoFilme = (TextView) itemView.findViewById(R.id.textViewDescricao);
            anoFilme = (TextView) itemView.findViewById(R.id.textViewAno);
            imgFilme = (ImageView) itemView.findViewById(R.id.imageViewFilme);
            posicaoFilme = (TextView) itemView.findViewById(R.id.textViewPosicao);

            itemView.setOnClickListener( new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    EditarFilme.posicao = Integer.valueOf((String) posicaoFilme.getText());
                    EditarFilme.tela = "Editar";
                    Intent i = new Intent(v.getContext(), EditarFilme.class);
                    v.getContext().startActivity(i);
                    activity.finish();
                    Log.i("poiscao", "posicao do FIlme:"+posicaoFilme.getText());

                }
            });
        }
    }


}


