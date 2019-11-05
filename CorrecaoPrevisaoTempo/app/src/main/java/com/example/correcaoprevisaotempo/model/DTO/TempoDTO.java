package com.example.correcaoprevisaotempo.model.DTO;

import com.example.correcaoprevisaotempo.model.entidade.Tempo;

public class TempoDTO {
    private String by;
    private boolean valid_key;
    private ResultadosDTO results;

    public TempoDTO() {
    }

    public TempoDTO(String by, boolean valid_key, ResultadosDTO results) {
        this.by = by;
        this.valid_key = valid_key;
        this.results = results;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public boolean isValid_key() {
        return valid_key;
    }

    public void setValid_key(boolean valid_key) {
        this.valid_key = valid_key;
    }

    public ResultadosDTO getResults() {
        return results;
    }

    public void setResults(ResultadosDTO results) {
        this.results = results;
    }

    public Tempo getTempo(){
        Tempo t = new Tempo();
        t.setResultado(results.getResultados());
        return t;
    }
}
