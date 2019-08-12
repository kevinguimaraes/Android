package com.example.tarefa22.model;

public class Boletim {
    private Disciplina d1;
    private Disciplina d2;

    public Boletim() {
    }

    public Boletim(Disciplina d1, Disciplina d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    public Disciplina getD1() {
        return d1;
    }

    public Disciplina getD2() {
        return d2;
    }

    public void setD1(Disciplina d1) {
        this.d1 = d1;
    }

    public void setD2(Disciplina d2) {
        this.d2 = d2;
    }
}
