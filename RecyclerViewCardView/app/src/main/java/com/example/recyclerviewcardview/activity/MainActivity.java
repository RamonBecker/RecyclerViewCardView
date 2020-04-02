package com.example.recyclerviewcardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerviewcardview.adapter.Adapter;
import com.example.recyclerviewcardview.adapter.model.Filme;
import com.example.recyclerviewcardview.R;
import com.example.recyclerviewcardview.controller.ControllerFIlme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Filme> listFilme;

    private RecyclerView recyclerView;
    private List<Filme> listaFilme;
    private ControllerFIlme controllerFIlme = ControllerFIlme.getInstance();


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        criarFilmes();

        recyclerView = findViewById(R.id.recyclerView);

        Adapter adapter = new Adapter(controllerFIlme.getListaFilme(), this);

        //  LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // layoutManager.setOrientation(LinearLayout.ver);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

    }

    public void criarFilmes() {

        controllerFIlme.addFilme(new Filme("Coringa", "Drama", 2019, "Filme do coringa", R.drawable.coringajpg));
        controllerFIlme.addFilme(new Filme("Band of Brothers", "Minissérie", 2001, "A história da Easy Company, integrante da 101a. Divisão do Exército dos Estados Unidos, na Segunda Guerra Mundial.", R.drawable.bandofbrothers));
        controllerFIlme.addFilme(new Filme("Coração Valente", "Guerra", 1995, "A história de um herói escocês do século 13, chamado William Wallace, que lidera seus conterrâneos contra o monarca inglês Edward I", R.drawable.coracaovalente));
        controllerFIlme.addFilme(new Filme("O resgate do soldado Ryan", "Guerra", 1998, "Ao desembarcar na Normandia, no dia 6 de junho de 1944, o Capitão Miller recebe a missão de comandar um grupo do Segundo Batalhão para o resgate do soldado James Ryan", R.drawable.oresgatedosoldadoryan));

    }
}
