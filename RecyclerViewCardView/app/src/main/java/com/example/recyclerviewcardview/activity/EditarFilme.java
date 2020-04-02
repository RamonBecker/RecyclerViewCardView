package com.example.recyclerviewcardview.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerviewcardview.R;
import com.example.recyclerviewcardview.adapter.model.Filme;
import com.example.recyclerviewcardview.controller.ControllerFIlme;


public class EditarFilme extends AppCompatActivity {
    public static int posicao;
    private TextView tituloFilme;
    private TextView generoFilme;
    private TextView anoFilme;
    private TextView descricaoFilme;
    private ImageView imgFilme;
    private ControllerFIlme controllerFIlme = ControllerFIlme.getInstance();
    private Filme filme;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editarfilme);

        tituloFilme = (TextView) findViewById(R.id.editTitulo);
        generoFilme = (TextView) findViewById(R.id.editGenero);
        descricaoFilme = (TextView) findViewById(R.id.editDescricao);
        anoFilme = (TextView) findViewById(R.id.editAno);
        imgFilme = (ImageView) findViewById(R.id.imageViewEditar);

        filme = controllerFIlme.getListaFilme().get(posicao);

        tituloFilme.setText(filme.getNome());
        generoFilme.setText(filme.getGenero());
        descricaoFilme.setText(filme.getDescricao());
        anoFilme.setText(String.valueOf(filme.getAno()));
        imgFilme.setImageResource(filme.getIdImagem());

    }

    public void concluir(){

    }

}
