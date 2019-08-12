package com.example.tarefa22.control;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.tarefa22.R;
import com.example.tarefa22.model.Boletim;
import com.example.tarefa22.model.BoletimBo;
import com.example.tarefa22.model.Disciplina;
import com.example.tarefa22.model.DisciplinaBo;
import com.example.tarefa22.view.MainActivity;

public class ResultadoControl {
    private Activity activity;
    private TextView nome1;
    private TextView media1;
    private  TextView situacao1;
    private TextView nome2;
    private TextView media2;
    private  TextView situacao2;
    private TextView mediaFinal;
    private TextView situacaoFinal;

    public ResultadoControl(Activity activity) {
        this.activity = activity;
        initComponents();
        showResult();
    }

    private void initComponents() {
        this.nome1 = activity.findViewById(R.id.txtDisciplina1);
        this.media1 = activity.findViewById(R.id.txtMedia1);
        this.situacao1 = activity.findViewById(R.id.txtSituacao1);
        this.nome2 = activity.findViewById(R.id.txtDisciplina2);
        this.media2 = activity.findViewById(R.id.txtMedia2);
        this.situacao2 = activity.findViewById(R.id.txtSituacao2);
        this.mediaFinal = activity.findViewById(R.id.txtMediaGeral);
        this.situacaoFinal = activity.findViewById(R.id.txtFinalResult);
    }

    private void showResult() {
        Disciplina d1 = (Disciplina) activity.getIntent().getSerializableExtra("d1");
        Disciplina d2 = (Disciplina) activity.getIntent().getSerializableExtra("d2");

        DisciplinaBo d1Bo = new DisciplinaBo(d1);
        DisciplinaBo d2Bo = new DisciplinaBo(d2);

        Boletim boletim  = new Boletim(d1, d2);
        BoletimBo boletimBo = new BoletimBo(boletim);

        this.nome1.setText(this.nome1.getText().toString() + ": " + d1.getNome());
        this.media1.setText(this.media1.getText().toString() + ": " + d1Bo.getMedia());
        this.situacao1.setText(this.situacao1.getText().toString() + ": " + d1Bo.getSituacao());

        this.nome2.setText(this.nome2.getText().toString() + ": " + d2.getNome());
        this.media2.setText(this.media2.getText().toString() + ": " + d2Bo.getMedia());
        this.situacao2.setText(this.situacao2.getText().toString() + ": " + d2Bo.getSituacao());

        this.mediaFinal.setText(this.mediaFinal.getText().toString() + ": " + boletimBo.getMedia());
        this.situacaoFinal.setText(this.situacaoFinal.getText().toString() + ": " + boletimBo.getSituacao());
    }

    public void retornarAction(){
        Intent it = new Intent(activity, MainActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(it);
    }
}
