package com.example.mylab.dao;

import android.content.Context;

import com.example.mylab.dao.helpers.DaoHelper;
import com.example.mylab.model.Estado;


public class EstadoDao extends DaoHelper<Estado> {

    public EstadoDao(Context c) {
        super(c, Estado.class);
    }
}
