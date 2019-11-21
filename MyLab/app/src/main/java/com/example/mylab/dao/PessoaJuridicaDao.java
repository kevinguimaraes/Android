package com.example.mylab.dao;

import android.content.Context;

import com.example.mylab.dao.helpers.DaoHelper;
import com.example.mylab.model.PessoaJuridica;


public class PessoaJuridicaDao extends DaoHelper<PessoaJuridica> {

    public PessoaJuridicaDao(Context c) {
        super(c, PessoaJuridica.class);
    }
}
