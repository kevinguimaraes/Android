package com.example.tarefa7.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class Comanda implements Serializable {
    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;

    @DatabaseField
    private Integer mesa;

    @DatabaseField
    private String local;

    public Comanda() {
    }

    public Comanda(Integer mesa, String local) {
        this.mesa = mesa;
        this.local = local;
    }

    public Comanda(Integer id, Integer mesa, String local) {
        this.id = id;
        this.mesa = mesa;
        this.local = local;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMesa() {
        return mesa;
    }

    public String getLocal() {
        return local;
    }
}
