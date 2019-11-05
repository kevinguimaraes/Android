package com.example.correcaoprevisaotempo.model.DTO;

import com.example.correcaoprevisaotempo.model.entidade.Previsao;

public class PrevisaoDTO {
    private String date;
    private String weekday;
    private int max;
    private int min;
    private String description;
    private String condition;

    public PrevisaoDTO() {
    }

    public PrevisaoDTO(String date, String weekday, int max, int min, String description, String condition) {
        this.date = date;
        this.weekday = weekday;
        this.max = max;
        this.min = min;
        this.description = description;
        this.condition = condition;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Previsao getPrevisao(){
        Previsao p = new Previsao();
        p.setData(date);
        p.setDiaSemana(weekday);
        p.setMaximo(max);
        p.setMinimo(min);
        return p;
    }
}
