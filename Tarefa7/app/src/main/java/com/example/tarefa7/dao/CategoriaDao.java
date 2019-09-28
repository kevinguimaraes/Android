package com.example.tarefa7.dao;

import android.content.Context;

import com.example.tarefa7.dao.helpers.DaoHelper;
import com.example.tarefa7.model.Categoria;

public class CategoriaDao extends DaoHelper<Categoria> {
    public CategoriaDao (Context c) {
        super(c, Categoria.class);
    }

}
