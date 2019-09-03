package com.example.provakevin.control;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.provakevin.R;
import com.example.provakevin.model.Config;
import com.example.provakevin.model.ConfigBO;
import com.example.provakevin.model.Dado;
import com.example.provakevin.uteis.Constantes;
import com.example.provakevin.view.ClienteActivity;

public class ConfigControl {
    private EditText editMin;
    private EditText editMax;
    private Activity activity;
    private Dado dado;
    private TextView tvResult;

    public ConfigControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        this.editMax = activity.findViewById(R.id.editMax);
        this.editMin = activity.findViewById(R.id.editMin);
        this.tvResult = activity.findViewById(R.id.tvResult);
        carregarForm();
    }

    private void carregarForm() {
        Config c = (Config) activity.getIntent().getSerializableExtra(Constantes.Parametros.CONFIG);
        if(c != null) {
            if (c.getMaximo() != null)
                this.editMax.setText(c.getMaximo().toString());
            if (c.getMinimo() != null)
                this.editMin.setText(c.getMinimo().toString());
        }


    }

    private Config getDadosForm() {
        Config c = new Config();
        c.setMaximo(this.editMax.getText().toString());
        c.setMinimo(this.editMin.getText().toString());
        return c;
    }

    private boolean valida(Config c) {
        if (!ConfigBO.valida(c)){
            this.editMax.setError(activity.getString(R.string.valida_config));
            this.editMax.requestFocus();
            return false;
        }
        return true;
    }


    public void enviarAction(){
        Config c = getDadosForm();
        if(valida(c)){
            Intent it = new Intent(activity, ClienteActivity.class);
            it.putExtra(Constantes.Parametros.CONFIG,c);
            it.putExtra(Constantes.Parametros.DADO, this.dado);
            activity.startActivityForResult(it, Constantes.Request.DADO);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == activity.RESULT_OK) {
            if (requestCode == Constantes.Request.DADO) {
                this.dado = (Dado) data.getSerializableExtra(Constantes.Parametros.DADO);
                this.tvResult.setText(this.dado.toString());
            }
        }else if(resultCode==activity.RESULT_CANCELED){
            Toast.makeText(activity, R.string.acao_cancelada, Toast.LENGTH_SHORT).show();
        }

    }

    public void cancelarAction(){
        activity.finish();
    }

}
