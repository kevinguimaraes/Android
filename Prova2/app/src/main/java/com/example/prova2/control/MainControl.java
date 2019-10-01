package com.example.prova2.control;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prova2.R;
import com.example.prova2.dao.AvaliacaoDao;
import com.example.prova2.dao.UnidadeCurricularDao;
import com.example.prova2.model.Avaliacao;
import com.example.prova2.model.UnidadeCurricular;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainControl {
    private Activity activity;

    private Spinner spUnidadeCurricular;
    private List<UnidadeCurricular> listUnidadeCurricular;
    private ArrayAdapter<UnidadeCurricular> adapterUnidadeCurricular;

    private EditText editAssunto;
    private EditText editNota;
    private TextView tvMedia;

    private ListView lvNotas;
    private List<Avaliacao> listAvaliacao;
    private ArrayAdapter<Avaliacao> adapterAvaliacao;

    private AvaliacaoDao avaliacaoDao;
    private UnidadeCurricularDao unidadeCurricularDao;
    private Avaliacao avaliacao;

    public MainControl(Activity activity) {
        this.activity = activity;
        avaliacaoDao = new AvaliacaoDao(activity);
        unidadeCurricularDao = new UnidadeCurricularDao(activity);

        initComponents();

    }

    private void initComponents() {
        spUnidadeCurricular = activity.findViewById(R.id.spUnidadeCurricular);
        lvNotas = activity.findViewById(R.id.lvNotas);
        editAssunto = activity.findViewById(R.id.editAssunto);
        editNota = activity.findViewById(R.id.editNota);
        tvMedia = activity.findViewById(R.id.tvMedia);
        initDataBase();
        configSpinner();
        configListView();
        atualizarTvMedia();
    }

    private void initDataBase() {
        try {
            unidadeCurricularDao.getDao().createIfNotExists(new UnidadeCurricular(1, "Mobile", "Renato"));
            unidadeCurricularDao.getDao().createIfNotExists(new UnidadeCurricular(2, "Web", "Rafael"));
            unidadeCurricularDao.getDao().createIfNotExists(new UnidadeCurricular(3, "TCS", "Maricel"));
            unidadeCurricularDao.getDao().createIfNotExists(new UnidadeCurricular(4, "Desktop", "Wilmar"));
            unidadeCurricularDao.getDao().createIfNotExists(new UnidadeCurricular(5, "Java", "Adriano"));
            avaliacaoDao.getDao().createIfNotExists(new Avaliacao(1,"Assunto 1", 1.0, new UnidadeCurricular(1, "Mobile", "Renato")));
            avaliacaoDao.getDao().createIfNotExists(new Avaliacao(2,"Assunto 2", 2.0, new UnidadeCurricular(1, "Mobile", "Renato")));
            avaliacaoDao.getDao().createIfNotExists(new Avaliacao(3,"Assunto 3", 3.0, new UnidadeCurricular(2, "Web", "Rafael")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void configSpinner() {
        try {
            listUnidadeCurricular = unidadeCurricularDao.getDao().queryForAll();
            adapterUnidadeCurricular = new ArrayAdapter<>(
                    activity,
                    android.R.layout.simple_spinner_item,
                    listUnidadeCurricular
            );
            spUnidadeCurricular.setAdapter(adapterUnidadeCurricular);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void configListView() {
        try {
            UnidadeCurricular u = (UnidadeCurricular) spUnidadeCurricular.getSelectedItem();
            listAvaliacao = avaliacaoDao.getDao().queryForAll();
        } catch (SQLException e) {
            listAvaliacao = new ArrayList<>();
        }
        adapterAvaliacao = new ArrayAdapter<>(
                activity,
                android.R.layout.simple_list_item_1,
                listAvaliacao
        );
        lvNotas.setAdapter(adapterAvaliacao);
        cliqueLongo();
    }

    private void cliqueLongo() {
        lvNotas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                avaliacao = adapterAvaliacao.getItem(position);
                dialogExcluir(avaliacao);
                return true;
            }
        });
    }

    private void dialogExcluir(final Avaliacao a) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
        alerta.setTitle(activity.getString(R.string.hint_assunto_avaliacao));
        alerta.setMessage("Assunto: " + a.getAssunto() + "\nNota: " + a.getNota() + "\nUnidade: " + a.getUnidadeCurricular().toString());
        alerta.setNeutralButton(activity.getString(R.string.fechar), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                avaliacao = null;
            }
        });
        alerta.setPositiveButton(activity.getString(R.string.excluir), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    if(avaliacaoDao.getDao().delete(a)>0) {
                        adapterAvaliacao.remove(a);
                        atualizarTvMedia();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                avaliacao = null;
            }
        });
        alerta.show();

    }


    private Avaliacao getDadosForm(){
        Avaliacao a = new Avaliacao();
        a.setAssunto(editAssunto.getText().toString());
        a.setNota(editNota.getText().toString());
        a.setUnidadeCurricular((UnidadeCurricular) spUnidadeCurricular.getSelectedItem());
        return a;
    }

    public void salvarAction() {
        Avaliacao a = getDadosForm();
        if (a.validaNome()) {
            if (a.validaNota()) {
                try {
                    if(avaliacaoDao.getDao().create(a) > 0) {
                        adapterAvaliacao.add(a);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                atualizarTvMedia();
            } else {
                editNota.setError(activity.getString(R.string.erro_nota));
                editNota.requestFocus();
            }
        }else {
            editAssunto.requestFocus();
            editAssunto.setError(activity.getString(R.string.erro_assunto));
        }

    }

    private Double getMedia(){
        double total = 0;
        for(Avaliacao a : listAvaliacao){
            total += a.getNota();
        }
        return total/listAvaliacao.size();
    }

    private void atualizarTvMedia(){
        tvMedia.setText(activity.getString(R.string.media_geral) + ": " + getMedia());
        limparForm();
    }

    private void limparForm(){
        editNota.setText("");
        editAssunto.setText("");
    }
}
