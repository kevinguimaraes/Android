package com.example.mylab.dao;

import android.content.Context;

import com.example.mylab.dao.helpers.DaoHelper;
import com.example.mylab.model.Medicao;


public class MedicaoDao extends DaoHelper<Medicao> {

    public MedicaoDao(Context c) {
        super(c, Medicao.class);
    }
}
