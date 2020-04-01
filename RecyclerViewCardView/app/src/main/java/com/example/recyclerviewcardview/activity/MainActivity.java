package com.example.recyclerviewcardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerviewcardview.adapter.Adapter;
import com.example.recyclerviewcardview.adapter.model.Filme;
import com.example.recyclerviewcardview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Filme> listFilme;

    private RecyclerView recyclerView;
    private List<Filme> listaFilme;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        criarFilmes();

        recyclerView = findViewById(R.id.recyclerView);

        Adapter adapter = new Adapter(listaFilme);

      //  LinearLayoutManager layoutManager = new LinearLayoutManager(this);
       // layoutManager.setOrientation(LinearLayout.ver);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

/*
        recyclerView.addOnItemTouchListener(
                new ClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new ClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), "Item pressionado"+listaFilme.get(position).getNome(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), "Click Longo"+listaFilme.get(position).getNome(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }

                )

        );

 */
    }

    public void criarFilmes(){
        listaFilme = new ArrayList<>();
        listaFilme.add(new Filme("Coringa", "Drama", 2019, "Filme do coringa", R.drawable.coringajpg));
        listaFilme.add(new Filme("Band of Brothers", "Minissérie",2001, "Historia da compania Easy" , R.drawable.bandofbrothers));
    }
}
