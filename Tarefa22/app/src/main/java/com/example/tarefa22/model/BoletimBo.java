package com.example.tarefa22.model;

public class BoletimBo {
    private Boletim b;

    public BoletimBo(Boletim b) {
        this.b = b;
    }

    public double getMedia() {
        DisciplinaBo dbo1 = new DisciplinaBo(this.b.getD1());
        DisciplinaBo dbo2 = new DisciplinaBo(this.b.getD2());

        return  (dbo1.getMedia() + dbo2.getMedia()) / 2;
    }

    public String getSituacao() {
        DisciplinaBo dbo1 = new DisciplinaBo(this.b.getD1());
        DisciplinaBo dbo2 = new DisciplinaBo(this.b.getD2());

        return dbo1.isAprovado() && dbo2.isAprovado() ? "Aprovado" : "Reprovado";
    }
}
