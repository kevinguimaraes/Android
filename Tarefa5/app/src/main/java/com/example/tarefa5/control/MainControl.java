package com.example.tarefa5.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.tarefa5.Uteis.Constantes;
import com.example.tarefa5.model.Disciplina;
import com.example.tarefa5.view.AvaliacaoActivity;
import com.example.tarefa5.view.ResultadoActivity;

public class MainControl {
    private Activity activity;
    private Disciplina disciplina1;
    private Disciplina disciplina2;

    public MainControl(Activity activity) {
        this.activity = activity;
        this.disciplina1 = new Disciplina();
        this.disciplina2 = new Disciplina();
    }

    public void telaDisciplina1Action(){
        Intent it = new Intent(activity, AvaliacaoActivity.class);
        activity.startActivityForResult(it, Constantes.Request.DISCIPLINA1);
    }

    public void telaDisciplina2Action(){
        Intent it = new Intent(activity, AvaliacaoActivity.class);
        activity.startActivityForResult(it, Constantes.Request.DISCIPLINA2);
    }

    public void telaResultadoAction() {
        Intent it = new Intent(activity, ResultadoActivity.class);
        it.putExtra(Constantes.Parametros.DISCIPLINA1, this.disciplina1);
        it.putExtra(Constantes.Parametros.DISCIPLINA2, this.disciplina2);
        activity.startActivity(it);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == activity.RESULT_OK) {
            if (requestCode == Constantes.Request.DISCIPLINA1){
                Disciplina disciplina =  (Disciplina) data.getSerializableExtra(Constantes.Parametros.DISCIPLINA1);
                this.disciplina1.;
                this.tvTeste.setText(endereco.toString());
            } else if (requestCode == Constantes.Request.DADO_PESSOAL) {
                DadoPessoal dadoPessoal = (DadoPessoal) data.getSerializableExtra(Constantes.Parametros.DADO_PESSOAL);
                this.pessoa.setDadoPessoal(dadoPessoal);
                this.tvTeste.setText(dadoPessoal.toString());
            }
        } else if (resultCode == activity.RESULT_CANCELED) {
            Toast.makeText(activity, "Ação cancelada", Toast.LENGTH_SHORT).show();
        }
    }
}
