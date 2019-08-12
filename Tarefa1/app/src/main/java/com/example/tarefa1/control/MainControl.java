package com.example.tarefa1.control;

import android.app.Activity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tarefa1.R;
import com.example.tarefa1.model.Pessoa;


public class MainControl {
    private EditText editNome;
    private EditText editNota1;
    private EditText editNota2;
    private TextView idResultado;
    private Activity activity;
    private LinearLayout layoutRes;

    public MainControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        this.editNome = activity.findViewById(R.id.editNome);
        this.editNota1 = activity.findViewById(R.id.editNota1);
        this.editNota2 = activity.findViewById(R.id.editNota2);
        this.idResultado = activity.findViewById(R.id.idResultado);
    }

    public void salvarAction() {
        Pessoa p = new Pessoa();
        p.setNome(this.editNome.getText().toString());
        p.setNota1(this.editNota1.getText().toString());
        p.setNota2(this.editNota2.getText().toString());

        if(p.getNome().isEmpty()){
            Toast.makeText(activity, R.string.nome_obrigatorio, Toast.LENGTH_SHORT).show();
            this.editNome.setError(activity.getString(R.string.nome_obrigatorio));
            return;
        }
        
        if (p.getNota1() <= 0) {
            Toast.makeText(activity, R.string.nota1_obrigatorio, Toast.LENGTH_SHORT).show();
            this.editNota1.setError(activity.getString(R.string.nota1_obrigatorio));
        }

        if (p.getNota2() <= 0) {
            Toast.makeText(activity, R.string.nota2_obrigatorio, Toast.LENGTH_SHORT).show();
            this.editNota2.setError(activity.getString(R.string.nota2_obrigatorio));
        }

        this.idResultado.setText(p.toString());

    }

    public void limparAction() {
        this.editNome.setText("");
        this.editNota1.setText("");
        this.editNota2.setText("");
    }




}
