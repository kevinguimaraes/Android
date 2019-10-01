package com.example.prova2.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class Avaliacao implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;

    @DatabaseField
    private String assunto;

    @DatabaseField
    private Double nota;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private UnidadeCurricular unidadeCurricular;

    public Avaliacao() {
    }

    public Avaliacao(String assunto, Double nota, UnidadeCurricular unidadeCurricular) {
        this.assunto = assunto;
        this.nota = nota;
        this.unidadeCurricular = unidadeCurricular;
    }

    public Avaliacao(Integer id, String assunto, Double nota, UnidadeCurricular unidadeCurricular) {
        this.id = id;
        this.assunto = assunto;
        this.nota = nota;
        this.unidadeCurricular = unidadeCurricular;
    }

    public void setUnidadeCurricular(UnidadeCurricular unidadeCurricular) {
        this.unidadeCurricular = unidadeCurricular;
    }

    public UnidadeCurricular getUnidadeCurricular() {
        return unidadeCurricular;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public void setNota(String nota) {
        try {
            this.nota = Double.parseDouble(nota);
        } catch (Exception e){
            this.nota = 0.0;
        }
    }

    public Integer getId() {
        return id;
    }

    public String getAssunto() {
        return assunto;
    }

    public Double getNota() {
        return nota;
    }

    public boolean validaNome() {
        if (this.assunto != null && !this.assunto.isEmpty())
            return true;
        else
            return false;
    }

    public boolean validaNota() {
        if (this.nota >= 0 && this.nota <= 10 && this.nota != null && !this.nota.isNaN() && !this.nota.toString().isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return this.assunto + " - " + this.nota;
    }
}
