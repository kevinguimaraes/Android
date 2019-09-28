package com.example.tarefa7.dao;

import android.content.Context;

import com.example.tarefa7.dao.helpers.DaoHelper;
import com.example.tarefa7.model.ItemComanda;

public class ItemComandaDao extends DaoHelper<ItemComanda> {
    public ItemComandaDao (Context c) {
        super(c, ItemComanda.class);
    }
}
