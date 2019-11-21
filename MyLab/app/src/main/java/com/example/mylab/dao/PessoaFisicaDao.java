package com.example.mylab.dao;

import android.content.Context;

import com.example.mylab.dao.helpers.DaoHelper;
import com.example.mylab.model.PessoaFisica;


public class PessoaFisicaDao extends DaoHelper<PessoaFisica> {

    public PessoaFisicaDao(Context c) {
        super(c, PessoaFisica.class);
    }
}
