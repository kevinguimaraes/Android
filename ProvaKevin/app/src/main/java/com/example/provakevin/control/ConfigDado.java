package com.example.provakevin.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.provakevin.R;
import com.example.provakevin.model.Config;
import com.example.provakevin.model.Dado;
import com.example.provakevin.model.DadoBO;
import com.example.provakevin.uteis.Constantes;

public class ConfigDado {
    private Activity activity;
    private EditText editNome;
    private NumberPicker npIdade;
    private Config c;

    public ConfigDado(Activity activity) {
        this.activity = activity;
        this.c = new Config();
        initComponents();
    }

    private void initComponents() {
        this.editNome = activity.findViewById(R.id.editNome);
        this.npIdade = activity.findViewById(R.id.npIdade);
        carregarForm();
    }

    private void carregarForm() {
        this.c = (Config) activity.getIntent().getSerializableExtra(Constantes.Parametros.CONFIG);
        Dado d = (Dado) activity.getIntent().getSerializableExtra(Constantes.Parametros.DADO);

        if (d != null) {
            this.editNome.setText(d.getNome());
            this.npIdade.setValue(d.getIdade());
        }
        if(this.c != null) {
            this.npIdade.setMaxValue(this.c.getMaximo());
            this.npIdade.setMinValue(this.c.getMinimo());
        }
    }

    private Dado getDadosForm() {
        Dado d = new Dado();
        d.setNome(this.editNome.getText().toString());
        d.setIdade(this.npIdade.getValue());
        return d;
    }

    private boolean valida(Dado d){
        DadoBO dadoBO = new DadoBO(d);
        if (!dadoBO.validaNome()){
            this.editNome.setError(activity.getString(R.string.nome_invalido));
            this.editNome.requestFocus();
            return false;
        }
        if (!dadoBO.validaIdade()){
            Toast.makeText(activity, activity.getString(R.string.idade_invalida), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void enviarAction(){
        Dado d = getDadosForm();
        if(valida(d)){
            Intent it = new Intent();
            it.putExtra(Constantes.Parametros.DADO, d);
            it.putExtra(Constantes.Parametros.CONFIG, this.c);
            activity.setResult(activity.RESULT_OK, it);
            activity.finish();
        }
    }

    public void cancelarAction(){
        activity.setResult(activity.RESULT_CANCELED);
        activity.finish();
    }



}
