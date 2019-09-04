package com.example.exemplolistview.model;

public class Estado {
    private String nome;
    private String sigla;

    public Estado() {
    }

    public Estado(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return nome + " (" + sigla + ")";
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }
}
