package com.example.exemploforresult.model;

public class PessoaBo {

    public static boolean validaNome(DadoPessoal d){
        return d.getNome()!=null
                && !d.getNome().isEmpty();
    }
    public static boolean validaIdade(DadoPessoal d){
        return d.getIdade()!=null
                && d.getIdade()>=0;
    }
    public static boolean validaCep(Endereco  e){
        return e.getCep()!=null
                && e.getCep().length()==9;
    }
    public static boolean validaCidade(Endereco e){
        return e.getCidade()!=null
                && !e.getCidade().isEmpty();
    }
}
