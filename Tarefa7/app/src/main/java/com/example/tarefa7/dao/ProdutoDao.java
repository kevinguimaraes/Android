package com.example.tarefa7.dao;

import android.content.Context;

import com.example.tarefa7.dao.helpers.DaoHelper;
import com.example.tarefa7.model.Produto;

public class ProdutoDao extends DaoHelper<Produto> {
    public ProdutoDao(Context c) {
        super(c, Produto.class);
    }
}
