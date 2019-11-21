package com.example.mylab.dao;

import android.content.Context;

import com.example.mylab.dao.helpers.DaoHelper;
import com.example.mylab.model.Cliente;


public class ClienteDao extends DaoHelper<Cliente> {

    public ClienteDao(Context c) {
        super(c, Cliente.class);
    }
}
