package com.example.exemplolistviewpersonalizado.model;

public class Pessoa {
    private String nome;
    private Integer idade;

    public Pessoa() {
    }

    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(String idade) {
        try {
            this.idade = Integer.parseInt(idade);
        } catch (Exception e) {
            this.idade = null;
        }
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
}
