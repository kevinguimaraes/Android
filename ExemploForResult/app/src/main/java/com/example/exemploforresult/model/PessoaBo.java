package com.example.exemploforresult.model;

public class PessoaBo {

    public static boolean validaNome(Pessoa p){
        return p.getDadoPessoal().getNome()!=null
                && !p.getDadoPessoal().getNome().isEmpty();
    }
    public static boolean validaIdade(Pessoa p){
        return p.getDadoPessoal().getIdade()!=null
                && p.getDadoPessoal().getIdade()>=0;
    }
    public static boolean validaCep(Pessoa p){
        return p.getEndereco().getCep()!=null
                && p.getEndereco().getCep().length()==9;
    }
    public static boolean validaCidade(Pessoa p){
        return p.getEndereco().getCidade()!=null
                && !p.getEndereco().getCidade().isEmpty();
    }
}
