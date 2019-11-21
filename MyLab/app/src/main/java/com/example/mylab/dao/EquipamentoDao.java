package com.example.mylab.dao;

import android.content.Context;

import com.example.mylab.dao.helpers.DaoHelper;
import com.example.mylab.model.Equipamento;


public class EquipamentoDao extends DaoHelper<Equipamento> {

    public EquipamentoDao(Context c) {
        super(c, Equipamento.class);
    }
}
