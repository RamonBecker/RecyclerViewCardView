package com.example.recyclerviewcardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcardview.adapter.model.Filme;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.FilmeViewHolder> {
    List<Filme> listFilme;


    RVAdapter(List<Filme> listFilme) {
        this.listFilme = listFilme;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


        @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, viewGroup, false);

        FilmeViewHolder filmeViewHolder = new FilmeViewHolder(v);

        return filmeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder filmeViewHolder, int position) {

        for (int i = 0; i < listFilme.size(); i ++){
            filmeViewHolder.tituloFilme.setText(listFilme.get(i).getNome());
            filmeViewHolder.generoFilme.setText(listFilme.get(i).getGenero());
            filmeViewHolder.descricaoFilme.setText(listFilme.get(i).getDescricao());
            filmeViewHolder.anoFilme.setText(String.valueOf(listFilme.get(i).getAno()));
            filmeViewHolder.imageFilme.setImageResource(listFilme.get(i).getIdImagem());
        }


    }

    @Override
    public int getItemCount() {
        return listFilme.size();
    }

    public static class FilmeViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tituloFilme;
        TextView generoFilme;
        TextView descricaoFilme;
        TextView anoFilme;
        ImageView imageFilme;

        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            tituloFilme = (TextView) itemView.findViewById(R.id.idTituloFilme);
            generoFilme = (TextView) itemView.findViewById(R.id.idGeneroFilme);
            descricaoFilme = (TextView) itemView.findViewById(R.id.idDescricaoFilme);
            anoFilme = (TextView) itemView.findViewById(R.id.idAnoFilme);
            imageFilme = (ImageView) itemView.findViewById(R.id.idImageFilme);
        }
    }
}
