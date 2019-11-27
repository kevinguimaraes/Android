package com.example.mylab.control;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class VisualizarControl {
    private Activity activity;

    private Spinner spAmostra;
    private List<Amostra> listAmostra;
    private ArrayAdapter<Amostra> adapterAmostra;
    private Amostra amostra;

    private ListView lvMedidas;
    private List<Medicao> listMedicao;
    private ArrayAdapter<Medicao> adapterMedicao;

    public VisualizarControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        spAmostra = activity.findViewById(R.id.spAmostra);
        lvMedidas = activity.findViewById(R.id.lvMedidas);
        carregarAmostras();
        carregarMedidas();

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

                Amostra a = (Amostra) spAmostra.getSelectedItem();

                adapterAmostra = new ArrayAdapter<>(
                        activity,
                        android.R.layout.simple_list_item_1,
                        listAmostra
                );
                spAmostra.setAdapter(adapterAmostra);

                adapterAmostra.addAll(listAmostra);
                //Toast.makeText(activity, listAmostra.size()+"Size", Toast.LENGTH_SHORT).show();
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

    private void carregarMedidas(){
        AsyncHttpClient client = new AsyncHttpClient();
        String URL = Constantes.Parametros.URL + "medicao";
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(activity, "Iniciando requisição", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String medicaoJSON = new String(bytes);
                Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

                Type medicaoListType = new TypeToken<ArrayList<Medicao>>(){}.getType();
                List<Medicao> listMedicao = gson.fromJson(medicaoJSON, medicaoListType);
                adapterMedicao = new ArrayAdapter<>(
                        activity,
                        android.R.layout.simple_list_item_1,
                        listMedicao
                );
                lvMedidas.setAdapter(adapterMedicao);
                adapterMedicao.addAll(listMedicao);
                Toast.makeText(activity, listMedicao.size()+"Size", Toast.LENGTH_SHORT).show();
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

}
