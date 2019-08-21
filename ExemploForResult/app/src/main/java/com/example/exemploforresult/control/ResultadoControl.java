package com.example.exemploforresult.control;

import android.app.Activity;
import android.widget.TextView;

import com.example.exemploforresult.R;
import com.example.exemploforresult.model.Pessoa;
import com.example.exemploforresult.uteis.Constantes;

public class ResultadoControl {
    private Activity activity;
    private TextView tvResultado;

    public ResultadoControl(Activity activity) {
        this.activity = activity;
        initComponents();
        showResultado();
    }

    private void showResultado() {
        Pessoa p = (Pessoa) activity.getIntent().getSerializableExtra(Constantes.Parametros.PESSOA);
        tvResultado.setText(p.toString());
    }

    private void initComponents() {
        tvResultado = activity.findViewById(R.id.tvResultado);
    }
}
