package com.example.provakevin.model;

import java.io.Serializable;

public class Config implements Serializable {
    private Integer maximo;
    private Integer minimo;

    public Config() {
    }

    public Config(Integer maximo, Integer minimo) {
        this.maximo = maximo;
        this.minimo = minimo;
    }

    public void setMaximo(String maximo){
        try {
            this.maximo = Integer.parseInt(maximo);
        } catch (Exception e) {
            this.maximo = null;
        }
    }

    public void setMinimo(String minimo){
        try {
            this.minimo = Integer.parseInt(minimo);
        } catch (Exception e) {
            this.maximo = null;
        }
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }

    public void setMinimo(Integer minimo) {
        this.minimo = minimo;
    }

    public Integer getMaximo() {
        return maximo;
    }

    public Integer getMinimo() {
        return minimo;
    }
}
