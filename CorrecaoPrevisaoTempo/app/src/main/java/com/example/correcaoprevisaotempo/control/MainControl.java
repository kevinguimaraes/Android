package com.example.correcaoprevisaotempo.control;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.correcaoprevisaotempo.R;
import com.example.correcaoprevisaotempo.model.DTO.TempoDTO;
import com.example.correcaoprevisaotempo.model.entidade.Previsao;
import com.example.correcaoprevisaotempo.model.entidade.Tempo;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainControl {
    private Activity activity;
    private TextView tvCidade;
    private TextView tvMinimo;
    private TextView tvMaximo;
    private ListView lvPrevisoes;
    private ArrayAdapter<Previsao> adapterPrevisoes;

    public MainControl(Activity activity) {
        this.activity = activity;
        initComponents();
        carregarPrevisao();
    }

    private void initComponents(){
        tvCidade = activity.findViewById(R.id.tvCidade);
        tvMinimo = activity.findViewById(R.id.tvMinimo);
        tvMaximo = activity.findViewById(R.id.tvMaximo);
        lvPrevisoes = activity.findViewById(R.id.lvPrevisoes);
    }

    private void carregarPrevisao(){
        AsyncHttpClient client = new AsyncHttpClient();
        String URL = "https://api.hgbrasil.com/weather?woeid=455861";
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(activity, "Iniciando requisição", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
                Toast.makeText(activity, "Tentativa "+retryNo, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String tempoJSON = new String(bytes);
                Gson gson = new Gson();

                //Converte o texto json para objeto
                TempoDTO tDTO = gson.fromJson(tempoJSON, TempoDTO.class);

                //Transforma o TempoDTO da API no Tempo do projeto
                Tempo t = tDTO.getTempo();
                preencherCidade(t);
                carregarListView(t);
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(activity, "Falhou.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void preencherCidade(Tempo t){
        tvCidade.setText(t.getResultado().getCidade());
    }

    private void carregarListView(Tempo t){
        adapterPrevisoes = new ArrayAdapter<>(
                activity,
                android.R.layout.simple_list_item_1,
                t.getResultado().getListPrevisoes()
        );
        lvPrevisoes.setAdapter(adapterPrevisoes);
        cliqueCurto();
    }

    private void cliqueCurto(){
        lvPrevisoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Previsao p = adapterPrevisoes.getItem(i);
                preecherTemperaturas(p);
            }
        });
    }

    private void preecherTemperaturas(Previsao p){
        tvMaximo.setText("Max\n"+p.getMaximo());
        tvMinimo.setText("Min\n"+p.getMinimo());
    }
}
