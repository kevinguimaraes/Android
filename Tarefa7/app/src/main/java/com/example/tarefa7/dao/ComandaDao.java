package com.example.tarefa7.dao;

import android.content.Context;

import com.example.tarefa7.dao.helpers.DaoHelper;
import com.example.tarefa7.model.Comanda;

public class ComandaDao extends DaoHelper<Comanda> {
    public ComandaDao (Context c) {
        super(c, Comanda.class);
    }
}
