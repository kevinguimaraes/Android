package com.example.exemplolistviewpersonalizado.model;

public class PessoaBO {
    public  static  boolean isMaiorIdade(Pessoa p){
        return p.getIdade()>=18;
    }

    public  static  boolean validaIdade(Pessoa p){
        return p.getIdade() != null;
    }

    public static boolean validaNome(Pessoa p ) {
        return p.getNome() != null && !p.getNome().isEmpty();
    }
}
