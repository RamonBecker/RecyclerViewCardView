package com.example.recyclerviewcardview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerviewcardview.R;
import com.example.recyclerviewcardview.adapter.Adapter;
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
    public static String tela = "";
    public static Adapter adapter = null;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editarfilme);

        tituloFilme = (TextView) findViewById(R.id.editTitulo);
        generoFilme = (TextView) findViewById(R.id.editGenero);
        descricaoFilme = (TextView) findViewById(R.id.editDescricao);
        anoFilme = (TextView) findViewById(R.id.editAno);
        imgFilme = (ImageView) findViewById(R.id.imageViewEditar);


        Log.i("Posicao", "Posicao:" + String.valueOf(posicao));

        setTexts();

    }

    public void concluir(View view) {
        Filme filme = null;

        if (tela.equals("Adicionar")) {
             filme = new Filme();
            filme.setNome(String.valueOf(tituloFilme.getText()));
            filme.setAno(Integer.parseInt(String.valueOf(anoFilme.getText())));
            filme.setGenero(String.valueOf(generoFilme.getText()));
            filme.setDescricao(String.valueOf(descricaoFilme.getText()));
            adapter.adicionarFilme(filme);
        }

        if (tela.equals("Editar")) {
            filme = new Filme();
            filme.setNome(String.valueOf(tituloFilme.getText()));
            filme.setAno(Integer.parseInt(String.valueOf(anoFilme.getText())));
            filme.setGenero(String.valueOf(generoFilme.getText()));
            filme.setDescricao(String.valueOf(descricaoFilme.getText()));
            adapter.editar(filme, posicao);

        }
        posicao = 0;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        finish();
    }

    public void setTexts() {
        if (tela.equals("Editar")) {
            filme = controllerFIlme.getListaFilme().get(posicao);
            tituloFilme.setText(filme.getNome());
            generoFilme.setText(filme.getGenero());
            descricaoFilme.setText(filme.getDescricao());
            anoFilme.setText(String.valueOf(filme.getAno()));
            imgFilme.setImageResource(filme.getIdImagem());

        }
    }
}
