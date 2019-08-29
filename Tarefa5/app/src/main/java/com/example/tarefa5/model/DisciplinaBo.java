package com.example.tarefa5.model;

public class DisciplinaBo {

    private Disciplina disciplina;

    public DisciplinaBo(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public double getMedia(){
        return (disciplina.getNota1() + disciplina.getNota2() ) / 2;
    }

    public boolean validaNome(){
        return this.disciplina.getNome()!=null && !this.disciplina.getNome().isEmpty();
    }

    public boolean validaNotas(){
        if(this.disciplina.getNota1() == null && this.disciplina.getNota1() < 0)
            return false;
        if(this.disciplina.getNota2() == null && this.disciplina.getNota2() < 0)
            return false;

        return true;
    }
}
