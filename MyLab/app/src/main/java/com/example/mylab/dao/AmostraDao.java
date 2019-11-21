package com.example.mylab.dao;

import android.content.Context;

import com.example.mylab.dao.helpers.DaoHelper;
import com.example.mylab.model.Amostra;


public class AmostraDao extends DaoHelper<Amostra> {

    public AmostraDao(Context c) {
        super(c, Amostra.class);
    }
}
