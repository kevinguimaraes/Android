package com.example.exemploforresult.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import com.example.exemploforresult.R;
import com.example.exemploforresult.model.DadoPessoal;
import com.example.exemploforresult.model.PessoaBo;
import com.example.exemploforresult.uteis.Constantes;

public class DadoPessoalControl {
    private Activity activity;
    private EditText editNome;
    private EditText editIdade;

    public DadoPessoalControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        this.editIdade = activity.findViewById(R.id.editIdade);
        this.editNome = activity.findViewById(R.id.editNome);
        carregarForm();
    }

    private void carregarForm() {
        DadoPessoal d = (DadoPessoal) activity.getIntent().getSerializableExtra(Constantes.Parametros.DADO_PESSOAL);
        this.editNome.setText(d.getNome());
        this.editIdade.setText(String.valueOf(d.getIdade()));
    }

    private DadoPessoal getDadosForm() {
        DadoPessoal d = new DadoPessoal();
        d.setNome(this.editNome.getText().toString());
        d.setIdade(this.editIdade.getText().toString());
        return d;
    }

    private boolean valida(DadoPessoal d) {
        if (!PessoaBo.validaNome(d)) {
            this.editNome.setError("Nome invalido");
            this.editNome.requestFocus();
            return false;
        }
        if (!PessoaBo.validaIdade(d)) {
            this.editIdade.setError("Idade invalido");
            this.editIdade.requestFocus();
            return false;
        }
        return true;
    }

    public void enviarAction() {
        DadoPessoal d = getDadosForm();
        if (valida(d)) {
            Intent it = new Intent();
            it.putExtra(Constantes.Parametros.DADO_PESSOAL, d);
            activity.setResult(activity.RESULT_OK, it);
            activity.finish();
        }
    }

    public void cancelarAction() {
        activity.setResult(activity.RESULT_CANCELED);
        activity.finish();
    }
}
