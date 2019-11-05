package com.example.correcaoprevisaotempo.model.entidade;

import javax.xml.transform.Result;

public class Tempo {
    private Resultados resultado;

    public Tempo() {
    }

    public Tempo(Resultados resultado) {
        this.resultado = resultado;
    }

    public Resultados getResultado() {
        return resultado;
    }

    public void setResultado(Resultados resultado) {
        this.resultado = resultado;
    }
}
