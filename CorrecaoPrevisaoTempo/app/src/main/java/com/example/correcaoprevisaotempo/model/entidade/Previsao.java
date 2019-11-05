package com.example.correcaoprevisaotempo.model.entidade;

import androidx.annotation.NonNull;

public class Previsao {
    private String data;
    private String diaSemana;
    private int minimo;
    private int maximo;

    public Previsao() {
    }

    public Previsao(String data, String diaSemana, int minimo, int maximo) {
        this.data = data;
        this.diaSemana = diaSemana;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    @NonNull
    @Override
    public String toString() {
        return data+" ("+diaSemana+")";
    }
}
