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
import com.example.tarefa22.view.SegundaActivity;

public class MainControl {
    private Activity activity;
    private EditText disciplina;
    private NumberPicker nota1;
    private NumberPicker nota2;
    private NumberPicker nota3;

    public MainControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        this.disciplina = activity.findViewById(R.id.edtDisciplina1);
        this.nota1 = activity.findViewById(R.id.nNota1);
        this.nota2 = activity.findViewById(R.id.nNota2);
        this.nota3 = activity.findViewById(R.id.nNota3);
        configurarNumberPicker(nota1);
        configurarNumberPicker(nota2);
        configurarNumberPicker(nota3);
    }

    private void configurarNumberPicker(NumberPicker np){
        np.setMinValue(Constantes.Notas.MINIMO);
        np.setMaxValue(Constantes.Notas.MAXIMO);
        np.setValue(Constantes.Notas.MEDIA_APROVACAO);
    }

    public boolean valida(DisciplinaBo d) {
        if(!d.validaDisciplina()){
            disciplina.setError(activity.getString(R.string.erro_nome));
            Toast.makeText(activity, R.string.erro_nome, Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!d.validaNotas()){
            Toast.makeText(activity, R.string.erro_nota, Toast.LENGTH_SHORT).show();
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
            Intent it = new Intent(activity, SegundaActivity.class);
            it.putExtra(Constantes.Parametros.DISCIPLINA1, d);
            activity.startActivity(it);
        }

    }

}
