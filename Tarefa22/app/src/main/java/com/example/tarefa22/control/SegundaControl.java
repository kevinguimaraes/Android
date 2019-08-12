package com.example.tarefa22.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.tarefa22.R;
import com.example.tarefa22.model.Disciplina;
import com.example.tarefa22.model.DisciplinaBo;
import com.example.tarefa22.uteis.Constantes;
import com.example.tarefa22.view.ResultadoActivity;
import com.example.tarefa22.view.SegundaActivity;

public class SegundaControl {
    private Activity activity;
    private EditText disciplina;
    private NumberPicker nota1;
    private NumberPicker nota2;
    private NumberPicker nota3;

    public SegundaControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        this.disciplina = activity.findViewById(R.id.edtDisciplina2);
        this.nota1 = activity.findViewById(R.id.nNota1);
        this.nota2 = activity.findViewById(R.id.nNota2);
        this.nota3 = activity.findViewById(R.id.nNota3);
        configurarNumberPicker();
    }

    private void configurarNumberPicker(){
        nota1.setMinValue(0);
        nota1.setMaxValue(10);
        nota1.setValue(7);
        nota2.setMinValue(0);
        nota2.setMaxValue(10);
        nota2.setValue(7);
        nota3.setMinValue(0);
        nota3.setMaxValue(10);
        nota3.setValue(7);
    }

    public boolean valida(DisciplinaBo d) {
        if(!d.validaDisciplina()){
            Toast.makeText(activity, "Digite nome valido", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!d.validaNotas()){
            Toast.makeText(activity, "Digite nota valida", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void proximoAction(){
        Disciplina d = new Disciplina();
        d.setNome(this.disciplina.getText().toString());
        d.setNota1(this.nota1.getValue());
        d.setNota2(this.nota2.getValue());
        d.setNota3(this.nota3.getValue());

        DisciplinaBo disciplinaBo = new DisciplinaBo(d);
        if(valida(disciplinaBo)){
            Intent it = new Intent(activity, ResultadoActivity.class);
            it.putExtra("d2", d);

            Disciplina d1 = (Disciplina) activity.getIntent().getSerializableExtra("d1");
            it.putExtra(Constantes.Parametros.DISCIPLINA1,d1);
            activity.startActivity(it);
        }

    }

}
