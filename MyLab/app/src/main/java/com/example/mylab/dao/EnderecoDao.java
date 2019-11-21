package com.example.mylab.dao;

import android.content.Context;

import com.example.mylab.dao.helpers.DaoHelper;
import com.example.mylab.model.Endereco;


public class EnderecoDao extends DaoHelper<Endereco> {

    public EnderecoDao(Context c) {
        super(c, Endereco.class);
    }
}
