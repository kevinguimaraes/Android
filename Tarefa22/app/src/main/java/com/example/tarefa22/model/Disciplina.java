package com.example.tarefa22.model;

import java.io.Serializable;

public class Disciplina implements Serializable {
    private String nome;
    private Integer nota1;
    private Integer nota2;
    private Integer nota3;

    public Disciplina() {
    }

    public Disciplina(String nome, Integer nota1, Integer nota2, Integer nota3) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNota1() {
        return nota1;
    }

    public Integer getNota2() {
        return nota2;
    }

    public Integer getNota3() {
        return nota3;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota1(Integer nota1) {
        this.nota1 = nota1;
    }

    public void setNota1(String nota1) {
        try{
            this.nota1 = Integer.parseInt(nota1);
        }catch (Exception e){
            this.nota1 = null;
        }
    }

    public void setNota2(Integer nota2) {
        this.nota2 = nota2;
    }

    public void setNota2(String nota2) {
        try{
            this.nota2 = Integer.parseInt(nota2);
        }catch (Exception e){
            this.nota2 = null;
        }
    }

    public void setNota3(Integer nota3) {
        this.nota3 = nota3;
    }

    public void setNota3(String nota3) {
        try{
            this.nota3 = Integer.parseInt(nota3);
        }catch (Exception e){
            this.nota3 = null;
        }
    }
}
