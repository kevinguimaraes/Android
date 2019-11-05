package com.example.correcaoprevisaotempo.model.entidade;

import java.util.List;

public class Resultados {
    private String data;
    private String cidade;
    private int temperatura;
    private int umidade;
    private List<Previsao> listPrevisoes;

    public Resultados() {

    }

    public Resultados(String data, String cidade, int temperatura, int umidade, List<Previsao> listPrevisoes) {
        this.data = data;
        this.cidade = cidade;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.listPrevisoes = listPrevisoes;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getUmidade() {
        return umidade;
    }

    public void setUmidade(int umidade) {
        this.umidade = umidade;
    }

    public List<Previsao> getListPrevisoes() {
        return listPrevisoes;
    }

    public void setListPrevisoes(List<Previsao> listPrevisoes) {
        this.listPrevisoes = listPrevisoes;
    }
}
