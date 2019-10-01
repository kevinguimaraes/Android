package com.example.prova2.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Collection;

@DatabaseTable
public class UnidadeCurricular implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;

    @DatabaseField
    private String nome;

    @DatabaseField
    private String nomeProfessor;

    @ForeignCollectionField(eager = true)
    private Collection<Avaliacao> colecaoAvaliacao;

    public UnidadeCurricular() {
    }

    public UnidadeCurricular(Integer id, String nome, String nomeProfessor) {
        this.id = id;
        this.nome = nome;
        this.nomeProfessor = nomeProfessor;
    }

    public UnidadeCurricular(Integer id, String nome, String nomeProfessor, Collection<Avaliacao> colecaoAvaliacao) {
        this.id = id;
        this.nome = nome;
        this.nomeProfessor = nomeProfessor;
        this.colecaoAvaliacao = colecaoAvaliacao;
    }

    public void setColecaoAvaliacao(Collection<Avaliacao> colecaoAvaliacao) {
        this.colecaoAvaliacao = colecaoAvaliacao;
    }

    public Collection<Avaliacao> getColecaoAvaliacao() {
        return colecaoAvaliacao;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    @Override
    public String toString() {
        return nome + "(" + nomeProfessor + ")";
    }

}
