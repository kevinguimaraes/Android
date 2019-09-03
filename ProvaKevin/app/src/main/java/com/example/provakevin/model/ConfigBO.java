package com.example.provakevin.model;

public class ConfigBO {
    public static boolean valida(Config c){
        return c.getMinimo()!=null && c.getMaximo()!=null && c.getMaximo()>=c.getMinimo();
    }
}
