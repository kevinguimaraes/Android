package com.example.exemploviacep.model;

public class Endereco {
    private String cep;
    private String rua;
    private String cidade;
    private String uf;

    public Endereco() {
    }

    public Endereco(String cep, String rua, String cidade, String uf) {
        this.cep = cep;
        this.rua = rua;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}