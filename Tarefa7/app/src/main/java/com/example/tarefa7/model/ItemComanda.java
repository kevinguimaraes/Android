package com.example.tarefa7.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class ItemComanda implements Serializable {
    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;

    @DatabaseField
    private Produto produto;

    @DatabaseField
    private int quantidade;

    public ItemComanda() {
    }

    public ItemComanda(Integer id, Produto produto, int quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ItemComanda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setQuantidade(String quantidade) {
        try {
            this.quantidade = Integer.parseInt(quantidade);
        } catch (Exception e){
            this.quantidade = 0;
        }
    }

    public void addQuantidade(){
        this.quantidade++;
    }

    public void removeQuantidade(){
        this.quantidade--;
    }

    public Double getSubtotal(){
        return produto.getValor() * quantidade;
    }

    @Override
    public String toString() {
        return produto.getNome() + " - R$" + produto.getValor()
                + " - " + quantidade + " = " + getSubtotal();
    }
}
