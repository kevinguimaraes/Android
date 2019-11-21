package com.example.mylab.dao;

import android.content.Context;

import com.example.mylab.dao.helpers.DaoHelper;
import com.example.mylab.model.Cidade;


public class CidadeDao extends DaoHelper<Cidade> {

    public CidadeDao(Context c) {
        super(c, Cidade.class);
    }
}
