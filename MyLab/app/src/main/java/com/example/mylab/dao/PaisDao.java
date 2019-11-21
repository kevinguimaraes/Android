package com.example.mylab.dao;

import android.content.Context;

import com.example.mylab.dao.helpers.DaoHelper;
import com.example.mylab.model.Pais;


public class PaisDao extends DaoHelper<Pais> {

    public PaisDao(Context c) {
        super(c, Pais.class);
    }
}
