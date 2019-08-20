package com.example.exemploforresult.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import com.example.exemploforresult.R;
import com.example.exemploforresult.model.Endereco;
import com.example.exemploforresult.uteis.Constantes;

public class EnderecoControl {
    private Activity activity;
    private EditText editCep;
    private EditText editCidade;

    public EnderecoControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        this.editCep = activity.findViewById(R.id.editCep);
        this.editCidade = activity.findViewById(R.id.editCidade);
        carregarForm();
    }

    private void carregarForm() {
        Endereco e  = (Endereco) activity.getIntent().getSerializableExtra(Constantes.Parametros.ENDERECO);
        this.editCep.setText(e.getCep());
        this.editCidade.setText(e.getCidade());
    }

    public boolean valida(Endereco e) {
        return true;
    }

    private Endereco getDadosForm(){
        Endereco e = new Endereco();
        e.setCep(this.editCep.getText().toString());
        e.setCidade(this.editCidade.getText().toString());
        return e;
    }

    public void enviarAction() {
        Endereco e = getDadosForm();
        if (valida(e)){
            Intent it = new Intent();
            it.putExtra(Constantes.Parametros.ENDERECO, e);
            activity.setResult(activity.RESULT_OK, it);
            activity.finish();
        }

    }

    public void cancelarAction() {
        activity.setResult(activity.RESULT_CANCELED);
        activity.finish();
    }
}
