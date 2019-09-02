package com.example.tarefa5.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tarefa5.R;
import com.example.tarefa5.Uteis.Constantes;
import com.example.tarefa5.model.Disciplina;

public class DisciplinaControl {
    private Activity activity;
    private EditText editNome;
    private EditText editNota1;
    private EditText editNota2;

    public DisciplinaControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        this.editNome = this.activity.findViewById(R.id.editDisciplina);
        this.editNota1 = this.activity.findViewById(R.id.editNota1);
        this.editNota2 = this.activity.findViewById(R.id.editNota2);
        Toast.makeText(activity, "tela init", Toast.LENGTH_SHORT).show();
    }


    public boolean valida(Disciplina d) {

        return true;
    }

    private Disciplina getDadosForm() {
        Disciplina d = new Disciplina();
        d.setNome(this.editNome.getText().toString());
        d.setNota1(this.editNota1.getText().toString());
        d.setNota2(this.editNota2.getText().toString());
        return d;
    }

    public void enviarAction() {
        Disciplina d = getDadosForm();
        if (valida(d)){
            Toast.makeText(activity, "tela Disciplina result", Toast.LENGTH_SHORT).show();
            Intent it = new Intent();
            it.putExtra(Constantes.Parametros.DISCIPLINA, d);
            activity.setResult(activity.RESULT_OK, it);
            activity.finish();
        }


    }

    public void cancelarAction() {
        Toast.makeText(activity, "tela Disciplina canceled", Toast.LENGTH_SHORT).show();
        activity.setResult(activity.RESULT_CANCELED);
        activity.finish();
    }

}
