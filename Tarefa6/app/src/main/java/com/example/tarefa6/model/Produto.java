package com.example.tarefa6.model;

import java.util.concurrent.ExecutionException;

public class Produto {
    private String nome;
    private Double valor;
    private Integer quantidae;

    public Produto() {
    }

    public Produto(String nome, Double valor, Integer quantidae) {
        this.nome = nome;
        this.valor = valor;
        this.quantidae = quantidae;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setValor(String valor){
        try {
            this.valor = Double.parseDouble(valor);
        } catch (Exception e) {
            this.valor = null;
        }
    }

    public void setQuantidae(Integer quantidae) {
        this.quantidae = quantidae;
    }

    public void setQuantidade(String quantidade){
        try {
            this.quantidae = Integer.parseInt(quantidade);
        }catch (Exception e) {
            this.quantidae = null;
        }
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getQuantidae() {
        return quantidae;
    }
}
