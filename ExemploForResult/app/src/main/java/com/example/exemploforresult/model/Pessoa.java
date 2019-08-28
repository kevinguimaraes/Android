package com.example.exemploforresult.model;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private DadoPessoal dadoPessoal;
    private Endereco endereco;
    private Contato contato;

    public Pessoa() {
        this.dadoPessoal = new DadoPessoal();
        this.endereco = new Endereco();
    }

    public Pessoa(DadoPessoal dadoPessoal, Endereco endereco, Contato contato) {
        this.dadoPessoal = dadoPessoal;
        this.endereco = endereco;
        this.contato = contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Contato getContato() {
        return contato;
    }

    public DadoPessoal getDadoPessoal() {
        return dadoPessoal;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setDadoPessoal(DadoPessoal dadoPessoal) {
        this.dadoPessoal = dadoPessoal;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return this.dadoPessoal.toString() + "\n" + this.endereco.toString();
    }
}
