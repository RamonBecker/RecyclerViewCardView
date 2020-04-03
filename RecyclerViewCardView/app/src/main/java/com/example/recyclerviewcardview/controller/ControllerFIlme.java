package com.example.recyclerviewcardview.controller;

import com.example.recyclerviewcardview.R;
import com.example.recyclerviewcardview.adapter.Adapter;
import com.example.recyclerviewcardview.adapter.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class ControllerFIlme {

    private static ControllerFIlme controllerFIlme;
    private List<Filme> listaFilme;

    private ControllerFIlme() {
        this.listaFilme = new ArrayList<>();
        criarFilmes();
    }

    public static ControllerFIlme getInstance() {
        if (controllerFIlme == null) {
            controllerFIlme = new ControllerFIlme();
        }
        return controllerFIlme;
    }

    public List<Filme> getListaFilme() {
        return listaFilme;
    }

    public void editar(int posicao, String titulo, String genero, String anoFilme, String descricao) {
        listaFilme.get(posicao).setNome(titulo);
        listaFilme.get(posicao).setAno(Integer.parseInt(anoFilme));
        listaFilme.get(posicao).setGenero(String.valueOf(genero));
        listaFilme.get(posicao).setDescricao(descricao);

    }

    public void criarFilmes() {

        getListaFilme().add(new Filme("Coringa", "Drama", 2019, "Filme do coringa", R.drawable.coringajpg));
        getListaFilme().add(new Filme("Band of Brothers", "Minissérie", 2001, "A história da Easy Company, integrante da 101a. Divisão do Exército dos Estados Unidos, na Segunda Guerra Mundial.", R.drawable.bandofbrothers));
        getListaFilme().add(new Filme("Coração Valente", "Guerra", 1995, "A história de um herói escocês do século 13, chamado William Wallace, que lidera seus conterrâneos contra o monarca inglês Edward I", R.drawable.coracaovalente));
        getListaFilme().add(new Filme("O resgate do soldado Ryan", "Guerra", 1998, "Ao desembarcar na Normandia, no dia 6 de junho de 1944, o Capitão Miller recebe a missão de comandar um grupo do Segundo Batalhão para o resgate do soldado James Ryan", R.drawable.oresgatedosoldadoryan));
        //  addFilme(new Filme("Band of Brothers", "Minissérie", 2001, "A história da Easy Company, integrante da 101a. Divisão do Exército dos Estados Unidos, na Segunda Guerra Mundial.", R.drawable.bandofbrothers));
    }


}
