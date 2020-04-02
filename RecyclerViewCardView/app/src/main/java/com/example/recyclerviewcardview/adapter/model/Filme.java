package com.example.recyclerviewcardview.adapter.model;

import java.util.ArrayList;
import java.util.List;

public class Filme {

    private String nome;
    private String genero;
    private String descricao;
    private int ano;
    private int idImagem;
    private boolean selected;


    public Filme() {
    }

    public Filme(String nome, String genero, int ano) {
        this.nome = nome;
        this.genero = genero;
        this.ano = ano;
    }

    public Filme(String nome, String genero, int ano, String descricao, int idImagem) {
        this.nome = nome;
        this.genero = genero;
        this.descricao = descricao;
        this.ano = ano;
        this.idImagem = idImagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
