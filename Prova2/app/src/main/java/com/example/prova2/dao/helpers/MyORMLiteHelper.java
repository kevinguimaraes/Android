package com.example.prova2.dao.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.prova2.model.Avaliacao;
import com.example.prova2.model.UnidadeCurricular;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class MyORMLiteHelper extends OrmLiteSqliteOpenHelper{
    private static final String DATABASE_NAME = "minha_pedida";
    private static final int DATABASE_VERSION = 1;
    public MyORMLiteHelper(Context c){
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Avaliacao.class);
            TableUtils.createTable(connectionSource, UnidadeCurricular.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, Avaliacao.class, true);
            TableUtils.dropTable(connectionSource, UnidadeCurricular.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
