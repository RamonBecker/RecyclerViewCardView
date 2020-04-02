package com.example.recyclerviewcardview.controller;

import com.example.recyclerviewcardview.adapter.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class ControllerFIlme {

    private static ControllerFIlme controllerFIlme;
    private List<Filme> listaFilme;

    private ControllerFIlme() {
        this.listaFilme = new ArrayList<>();
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

    public void addFilme(Filme filme) {
        if (listaFilme == null) {
            listaFilme = new ArrayList<>();
        }
        listaFilme.add(filme);
    }
}
