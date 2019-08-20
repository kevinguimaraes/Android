package com.example.exemploforresult.model;

import java.io.Serializable;

public class Endereco implements Serializable {
    private String cep;
    private String cidade;

    public Endereco() {
    }

    public Endereco(String cep, String cidade) {
        this.cep = cep;
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "CEP: " + this.cep + "\nCidade" + this.cidade;
    }
}
