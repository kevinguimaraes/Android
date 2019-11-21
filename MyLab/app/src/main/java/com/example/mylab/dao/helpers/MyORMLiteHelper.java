package com.example.mylab.dao.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mylab.model.Equipamento;
import com.example.mylab.model.Cidade;
import com.example.mylab.model.Cliente;
import com.example.mylab.model.Endereco;
import com.example.mylab.model.Equipamento;
import com.example.mylab.model.Estado;
import com.example.mylab.model.Medicao;
import com.example.mylab.model.Pais;
import com.example.mylab.model.PessoaFisica;
import com.example.mylab.model.PessoaJuridica;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class MyORMLiteHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "mylab";
    private static final int DATABASE_VERSION = 1;
    public MyORMLiteHelper(Context c){
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Equipamento.class);
            TableUtils.createTable(connectionSource, Cidade.class);
            TableUtils.createTable(connectionSource, Cliente.class);
            TableUtils.createTable(connectionSource, Endereco.class);
            TableUtils.createTable(connectionSource, Equipamento.class);
            TableUtils.createTable(connectionSource, Estado.class);
            TableUtils.createTable(connectionSource, Medicao.class);
            TableUtils.createTable(connectionSource, Pais.class);
            TableUtils.createTable(connectionSource, PessoaFisica.class);
            TableUtils.createTable(connectionSource, PessoaJuridica.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, Equipamento.class, true);
            TableUtils.dropTable(connectionSource, Cidade.class, true);
            TableUtils.dropTable(connectionSource, Cliente.class, true);
            TableUtils.dropTable(connectionSource, Endereco.class, true);
            TableUtils.dropTable(connectionSource, Equipamento.class, true);
            TableUtils.dropTable(connectionSource, Estado.class, true);
            TableUtils.dropTable(connectionSource, Medicao.class, true);
            TableUtils.dropTable(connectionSource, Pais.class, true);
            TableUtils.dropTable(connectionSource, PessoaJuridica.class, true);
            TableUtils.dropTable(connectionSource, PessoaFisica.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
