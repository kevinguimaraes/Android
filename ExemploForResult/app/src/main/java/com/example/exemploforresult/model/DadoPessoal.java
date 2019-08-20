package com.example.exemploforresult.model;

import android.content.Intent;

import java.io.Serializable;

public class DadoPessoal implements Serializable {
    private String nome;
    private Integer idade;

    public DadoPessoal() {
    }

    public DadoPessoal(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setIdade(String idade){
        try {
            this.idade = Integer.parseInt(idade);
        } catch (Exception e){
            this.idade = null;
        }
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\nIdade: " + this.idade;
    }
}
