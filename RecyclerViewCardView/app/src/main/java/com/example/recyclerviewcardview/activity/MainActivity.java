package com.example.recyclerviewcardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerviewcardview.adapter.Adapter;
import com.example.recyclerviewcardview.adapter.model.Filme;
import com.example.recyclerviewcardview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Filme> listFilme;

    private RecyclerView recyclerView;
    private List<Filme> listaFilme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        criarFilmes();

        recyclerView = findViewById(R.id.recyclerView);

        Adapter adapter = new Adapter();



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }

    public void criarFilmes(){
        listaFilme = new ArrayList<>();
        listaFilme.add(new Filme("Coringa", "Drama", 2019));
        listaFilme.add(new Filme("Batman", "Drama", 2008));

    }
}
