package com.example.exemploforresult.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import com.example.exemploforresult.R;
import com.example.exemploforresult.model.Contato;
import com.example.exemploforresult.uteis.Constantes;

public class ContatoControl {

    private Activity activity;
    private EditText editTelefone;
    private EditText editEmail;

    public ContatoControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        this.editTelefone = activity.findViewById(R.id.editTelefone);
        this.editEmail = activity.findViewById(R.id.editEmail);
        carregarForm();
    }

    private void carregarForm() {
        Contato e  = (Contato) activity.getIntent().getSerializableExtra(Constantes.Parametros.CONTATO);
        this.editTelefone.setText(e.getTelefone());
        this.editEmail.setText(e.getEmail());
    }

    public boolean valida(Contato e) {
//        if(!PessoaBo.validaCep(e)){
//            editTelefone.setError("Telefone Invalido");
//            editTelefone.requestFocus();
//            return false;
//        }
//        if (!PessoaBo.validaCidade(e)) {
//            editEmail.setError("Email Invalida");
//            editEmail.requestFocus();
//        }
        return true;
    }

    private Contato getDadosForm(){
        Contato e = new Contato();
        e.setEmail(this.editEmail.getText().toString());
        e.setTelefone(this.editTelefone.getText().toString());
        return e;
    }

    public void enviarAction() {
        Contato e = getDadosForm();
        if (valida(e)){
            Intent it = new Intent();
            it.putExtra(Constantes.Parametros.CONTATO, e);
            activity.setResult(activity.RESULT_OK, it);
            activity.finish();
        }

    }

    public void cancelarAction() {
        activity.setResult(activity.RESULT_CANCELED);
        activity.finish();
    }
}
