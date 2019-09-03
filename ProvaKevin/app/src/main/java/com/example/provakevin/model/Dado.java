package com.example.provakevin.model;

import java.io.Serializable;

public class Dado implements Serializable {
    private String nome;
    private Integer idade;

    public Dado() {
    }

    public Dado(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void setIdade(String idade) {
        try {
            this.idade = Integer.parseInt(idade);
        }catch (Exception e){
            this.idade = null;
        }


    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "nome = " + nome + "\n" + "idade = " + idade;
    }
}
