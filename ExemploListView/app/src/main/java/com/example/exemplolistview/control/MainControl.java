package com.example.exemplolistview.control;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.exemplolistview.R;
import com.example.exemplolistview.model.Estado;

import java.util.ArrayList;
import java.util.List;

public class MainControl {
    private Activity activity;
    private EditText editNome;
    private EditText editSigla;
    private TextView tvContagem;
    private ListView lvEstado;
    private List<Estado> listEstado;
    private ArrayAdapter<Estado> adapterEstado;
    private Estado estado;

    public MainControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        this.editNome = activity.findViewById(R.id.editNomeEstado);
        this.editSigla = activity.findViewById(R.id.editSiglaEstado);
        tvContagem = activity.findViewById(R.id.tvContagem);
        lvEstado = activity.findViewById(R.id.lvEstado);
        configListView();
    }

    private void configListView() {
        this.listEstado = new ArrayList<>();
        listEstado.add(new Estado("Acre", "AC"));
        adapterEstado = new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1);
        lvEstado.setAdapter(adapterEstado);
        adapterEstado.add(new Estado("Santa Catarina", "SC"));
        cliqueCurto();
        cliqueLongo();
    }

    private void cliqueCurto() {
        lvEstado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                estado = adapterEstado.getItem(i);
                dialogEditarEstado(estado);
            }
        });
    }

    private void cliqueLongo() {
        lvEstado.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                estado = adapterEstado.getItem(i);
                dialogExcluirEstado(estado);
                //return false; //executa o clique curto junto
                return true; //executa somente clique longo
            }
        });
    }

    private void addEstadoLv(Estado e){
        adapterEstado.add(e);
    }

    private void excluirEstadoLv(Estado e){
        adapterEstado.remove(e);
    }

    private void atualizarEstadoLv(Estado e){
        estado.setNome(e.getNome());
        estado.setSigla(e.getSigla());
        adapterEstado.notifyDataSetChanged();
    }

    private Estado getDadosForm(){
        Estado e = new Estado();
        e.setNome(editNome.getText().toString());
        e.setSigla(editSigla.getText().toString());
        return e;
    }

    private void carregarForm(Estado e) {
        editNome.setText(e.getNome());
        editSigla.setText(e.getSigla());
    }

    private void atualizarContador(){
        tvContagem.setText("Contagem: " + adapterEstado.getCount());
    }

    private void dialogExcluirEstado(final Estado e){
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setTitle("Excluindo estado");
        alerta.setMessage(e.toString());
        alerta.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                estado = null;
            }
        });
        alerta.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                excluirEstadoLv(e);
                atualizarContador();
            }
        });
        alerta.show();
    }

    private void dialogEditarEstado(final Estado e){
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setTitle("Mostrando dados");
        alerta.setMessage(e.toString());
        alerta.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                estado = null;
            }
        });
        alerta.setPositiveButton("Editar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                carregarForm(e);
            }
        });
        alerta.show();
    }

    public void salvarAction(){
        if (estado == null){
            Estado e = getDadosForm();
            atualizarContador();
            addEstadoLv(e);
        } else {
            Estado e = getDadosForm();
            atualizarEstadoLv(e);
        }
        estado = null;
    }




}
