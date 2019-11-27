package com.example.mylab.control;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mylab.R;
import com.example.mylab.model.Amostra;
import com.example.mylab.model.Equipamento;
import com.example.mylab.model.Medicao;
import com.example.mylab.util.Constantes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class EnviarControl {
    private Activity activity;
    private Spinner spEquipamento;
    private List<Equipamento> listEquipamento;
    private ArrayAdapter<Equipamento> adapterEquipamento;

    private Spinner spAmostra;
    private List<Amostra> listAmostra;
    private ArrayAdapter<Amostra> adapterAmostra;

    private EditText editValor;
    private EditText editUnidade;
    private EditText editData;

    private Equipamento equipamento;
    private Amostra amostra;

    public EnviarControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        editData = activity.findViewById(R.id.editData);
        editUnidade = activity.findViewById(R.id.editUnidade);
        editValor = activity.findViewById(R.id.editValor);
        spEquipamento = activity.findViewById(R.id.spEquipamento);
        spAmostra = activity.findViewById(R.id.spAmostra);
        carregarEquipamentos();
        carregarAmostras();
    }

    private void carregarAmostras() {
        AsyncHttpClient client = new AsyncHttpClient();
        String URL = Constantes.Parametros.URL + "amostra";
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(activity, "Iniciando requisição", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String amostraJSON = new String(bytes);
                Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
                Type amostraListType = new TypeToken<ArrayList<Amostra>>(){}.getType();
                List<Amostra> listAmostra= gson.fromJson(amostraJSON, amostraListType);

                adapterAmostra = new ArrayAdapter<>(
                        activity,
                        android.R.layout.simple_list_item_1,
                        listAmostra
                );
                spAmostra.setAdapter(adapterAmostra);

                adapterAmostra.addAll(listAmostra);
                Toast.makeText(activity, listAmostra.size()+"Size", Toast.LENGTH_SHORT).show();
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

                adapterEquipamento = new ArrayAdapter<>(
                        activity,
                        android.R.layout.simple_list_item_1,
                        listEquipamento
                );
                spEquipamento.setAdapter(adapterEquipamento);

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

    public void enviarAction() {
        RequestParams params = new RequestParams();
        AsyncHttpClient client = new AsyncHttpClient();
        String URL = Constantes.Parametros.URL + "medicao";
        Gson gson = new Gson();
        client.addHeader("user-agent", "Chrome Mozilla");
        Medicao m = getDadosForm();
        m.setEquipamento((Equipamento)spEquipamento.getSelectedItem());
        m.setAmostra((Amostra)spAmostra.getSelectedItem());
        params.put("dado", gson.toJson(m));
        Toast.makeText(activity, gson.toJson(m), Toast.LENGTH_LONG).show();

        client.post(URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(activity, "Iniciando requisição", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                Toast.makeText(activity, "Enviado  com sucesso!", Toast.LENGTH_SHORT).show();
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

    private Medicao getDadosForm() {
        Medicao m = new Medicao();
        try {
            m.setDt_Medicao(new SimpleDateFormat("yyyy/MM/dd").parse(editData.getText().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        m.setUnidade(editUnidade.getText().toString());
        m.setValor(Double.parseDouble(editValor.getText().toString()));
        m.setAmostra(this.amostra);
        m.setEquipamento(this.equipamento);

        return m;
    }
}
