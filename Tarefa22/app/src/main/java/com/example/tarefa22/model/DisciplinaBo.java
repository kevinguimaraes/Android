package com.example.tarefa22.model;

import com.example.tarefa22.uteis.Constantes;

public class DisciplinaBo {
    private Disciplina disciplina;

    public DisciplinaBo(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public double getMedia(){
        return (disciplina.getNota1() + disciplina.getNota2() + disciplina.getNota3()) / 3;
    }

    public boolean isAprovado() {
        return getMedia() >= Constantes.Notas.MEDIA_APROVACAO;
    }

    public String getSituacao() {
        return isAprovado() ? "Aprovado" : "Reprovado";
    }
//teste do git
    public boolean validaDisciplina(){
        return this.disciplina.getNome()!=null && !this.disciplina.getNome().isEmpty();
    }

    public boolean validaNotas(){
        if(this.disciplina.getNota1() == null && this.disciplina.getNota1() < 0)
            return false;
        if(this.disciplina.getNota2() == null && this.disciplina.getNota2() < 0)
            return false;
        if(this.disciplina.getNota3() == null && this.disciplina.getNota3() < 0)
            return false;

        return true;
    }

}
