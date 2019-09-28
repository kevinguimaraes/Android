package com.example.tarefa7.control;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.tarefa7.R;
import com.example.tarefa7.dao.ComandaDao;
import com.example.tarefa7.model.Comanda;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainControl {
    private Activity activity;
    private EditText editMesa;
    private ListView lvComanda;
    private List<Comanda> listComanda;
    private ArrayAdapter<Comanda> adapterComanda;
    private Comanda comanda;
    private ComandaDao comandaDao;

    public MainControl(Activity activity) {
        this.activity = activity;
        comandaDao = new ComandaDao(activity);
        initComponents();
    }

    private void initComponents() {
        editMesa = activity.findViewById(R.id.editMesa);
        lvComanda = activity.findViewById(R.id.lvComanda);
        configListView();
    }

    private void configListView() {
        try {
            listComanda = comandaDao.getDao().queryForAll();
        } catch (SQLException e) {
            listComanda = new ArrayList<>();
        }
        adapterComanda = new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1, listComanda);
        lvComanda.setAdapter(adapterComanda);
        cliqueLongo();
    }

    private void cliqueLongo(){
        lvComanda.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                comanda = adapterComanda.getItem(position);
                dialogExcluir(comanda);
                return true;
            }
        });
    }

    private void dialogExcluir(final Comanda c){
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setTitle("Excluindo item");
        alerta.setMessage(c.toString());
        alerta.setNeutralButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                comanda = null;
            }
        });
        alerta.setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    if(comandaDao.getDao().delete(c)>0) {
                        adapterComanda.remove(c);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                comanda = null;
            }
        });
        alerta.show();
    }
}
