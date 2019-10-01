package com.example.prova2.dao;

import android.content.Context;

import com.example.prova2.dao.helpers.DaoHelper;
import com.example.prova2.model.UnidadeCurricular;

public class UnidadeCurricularDao extends DaoHelper<UnidadeCurricular> {
    public UnidadeCurricularDao(Context c) {
        super(c, UnidadeCurricular.class);
    }
}
