package com.example.mylab.control;

import android.app.Activity;
import android.preference.PreferenceActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mylab.R;
import com.example.mylab.dao.EquipamentoDao;
import com.example.mylab.model.Amostra;
import com.example.mylab.model.Equipamento;
import com.example.mylab.util.Constantes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastrarControl {
    private Activity activity;
    private EditText editNome;
    private EditText editSerial;
    private EditText editVersao;
    private EditText editFwVersao;
    private ListView lvEquipamentos;

    private List<Equipamento> listEquipamento;
    private ArrayAdapter<Equipamento> adapterEquipamento;

    private EquipamentoDao equipamentoDao;
    private Equipamento equipamento;

    public CadastrarControl(Activity activity) {
        this.activity = activity;
        equipamentoDao = new EquipamentoDao(activity);
        initComponents();
    }

    private void initComponents() {
        editNome = activity.findViewById(R.id.editNome);
        editSerial = activity.findViewById(R.id.editSerial);
        editVersao = activity.findViewById(R.id.editVersao);
        editFwVersao = activity.findViewById(R.id.editFwVersao);
        lvEquipamentos = activity.findViewById(R.id.lvEquipamentos);
        configListView();
        carregarEquipamentos();
    }

    private void configListView() {
        try {
            listEquipamento = equipamentoDao.getDao().queryForAll();
            listEquipamento = new ArrayList<Equipamento>();
        } catch (SQLException e) {
            listEquipamento = new ArrayList<>();
        }
        adapterEquipamento = new ArrayAdapter<>(
                activity,
                android.R.layout.simple_list_item_1,
                listEquipamento
        );
        lvEquipamentos.setAdapter(adapterEquipamento);
    }

    public void enviarAction(){
        RequestParams params = new RequestParams();
        AsyncHttpClient client = new AsyncHttpClient();
        String URL = Constantes.Parametros.URL + "equipamento";
        Gson gson = new Gson();
        client.addHeader("user-agent", "Chrome Mozilla");
        Equipamento e = getDadosForm();
        params.put("dado", gson.toJson(e));

        client.post(URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(activity, "Iniciando requisição", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                adapterEquipamento.add(getDadosForm());
                Toast.makeText(activity, listEquipamento.size()+"Size", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
                Toast.makeText(activity, "Tentativa "+retryNo, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(activity, "Falhou." + i, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void carregarEquipamentos(){
        AsyncHttpClient client = new AsyncHttpClient();
        String URL = Constantes.Parametros.URL + "equipamento";
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(activity, "Iniciando requisição", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String equipamentoJSON = new String(bytes);
                Gson gson = new Gson();

                Type equipamentoListType = new TypeToken<ArrayList<Equipamento>>(){}.getType();
                List<Equipamento> listEquipamento = gson.fromJson(equipamentoJSON, equipamentoListType);
                adapterEquipamento.addAll(listEquipamento);
                Toast.makeText(activity, listEquipamento.size()+"Size", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
                Toast.makeText(activity, "Tentativa "+retryNo, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(activity, "Falhou.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public Equipamento getDadosForm(){
        Equipamento e = new Equipamento();
        e.setId(null);
        e.setNome(editNome.getText().toString());
        e.setSerial(editSerial.getText().toString());
        e.setFw_version(editFwVersao.getText().toString());
        e.setHw_version(editVersao.getText().toString());
        return e;
    }
}
