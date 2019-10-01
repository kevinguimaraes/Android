package com.example.prova2.dao;

import android.content.Context;

import com.example.prova2.dao.helpers.DaoHelper;
import com.example.prova2.model.Avaliacao;

public class AvaliacaoDao extends DaoHelper<Avaliacao> {

    public AvaliacaoDao(Context c) {
        super(c, Avaliacao.class);
    }
}
