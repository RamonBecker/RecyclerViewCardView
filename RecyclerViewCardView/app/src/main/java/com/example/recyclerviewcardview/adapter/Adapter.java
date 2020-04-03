package com.example.recyclerviewcardview.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.audiofx.NoiseSuppressor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerviewcardview.R;
import com.example.recyclerviewcardview.activity.EditarFilme;
import com.example.recyclerviewcardview.adapter.model.Filme;
import com.example.recyclerviewcardview.controller.ControllerFIlme;
import com.google.android.material.snackbar.Snackbar;
import java.util.Collections;

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

    public void mover(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(controllerFIlme.getListaFilme(), i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(controllerFIlme.getListaFilme(), i, i - 1);
            }

            notifyItemMoved(fromPosition, toPosition);
        }

    }

    public void editar(Filme filme, int position){
        controllerFIlme.getListaFilme().get(position).setNome(filme.getNome());
        controllerFIlme.getListaFilme().get(position).setAno(filme.getAno());
        controllerFIlme.getListaFilme().get(position).setGenero(filme.getGenero());
        controllerFIlme.getListaFilme().get(position).setDescricao(filme.getDescricao());
        notifyItemChanged(position);
    }

    public void adicionarFilme(Filme filme){
        controllerFIlme.getListaFilme().add(filme);
        notifyItemInserted(getItemCount());
    }



    public void remover(int position) {
        final int posicaoRemovida = position;
        final Filme filmeRemovido = controllerFIlme.getListaFilme().get(position);
        controllerFIlme.getListaFilme().remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, this.getItemCount());

        Snackbar snackbar = Snackbar.make(activity.findViewById(R.id.constraintLayout), "Item deletado", Snackbar.LENGTH_LONG);
        snackbar.setAction("Desfazer ?", new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                controllerFIlme.getListaFilme().add(posicaoRemovida, filmeRemovido);
                notifyItemInserted(posicaoRemovida);
            }
        });
        snackbar.show();
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Filme filme = controllerFIlme.getListaFilme().get(position);

        holder.tituloFilme.setText(filme.getNome());
        holder.generoFilme.setText(filme.getGenero());
        holder.anoFilme.setText(String.valueOf(filme.getAno()));
        holder.descricaoFilme.setText(filme.getDescricao());
        holder.imgFilme.setImageResource(filme.getIdImagem());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), EditarFilme.class);
                v.getContext().startActivity(i);
                EditarFilme.tela = "Editar";
                EditarFilme.posicao = holder.getAdapterPosition();
            }
        });
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
        }
    }
}


