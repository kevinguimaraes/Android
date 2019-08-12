package com.example.tarefa1.model;

public class Pessoa {
    private String nome;
    private double nota1;
    private double nota2;

    public Pessoa() {
    }

    public Pessoa(String nome, int nota1, int nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota1(String nota1) {
        try {
            setNota1(Integer.parseInt(nota1));
        }catch (Exception e){
            setNota1(0);
        }
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setNota2(String nota2) {
        try {
            setNota1(Double.parseDouble(nota2));
        }catch (Exception e){
            setNota1(0);
        }
    }


    public double getMedia() {
        return (this.nota1 + this.nota2) / 2;
    }

    public boolean isAprovado(){
        return this.getMedia() >= 7;
    }


    @Override
    public String toString() {
        return  "Aluno: " + this.nome +
                "\nMedia: " + this.getMedia() +
                "\nSituação: "  + ((this.isAprovado()) ? "Aprovado" : "Reprovado");
    }
}
