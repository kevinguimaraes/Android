package com.example.tarefa6.model;

public class ProdutoBo {
    public static Double getTotal(Produto p){
        return p.getValor() * p.getQuantidae();
    }
}
