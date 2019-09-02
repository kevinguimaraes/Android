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
        Toast.makeText(activity, "tela Disciplina 1", Toast.LENGTH_SHORT).show();
        activity.startActivityForResult(it, Constantes.Request.DISCIPLINA1);
    }

    public void telaDisciplina2Action(){
        Intent it = new Intent(activity, AvaliacaoActivity.class);
        Toast.makeText(activity, "tela Disciplina 2", Toast.LENGTH_SHORT).show();
        activity.startActivityForResult(it, Constantes.Request.DISCIPLINA2);
    }

    public void telaResultadoAction() {
        Intent it = new Intent(activity, ResultadoActivity.class);
        it.putExtra(Constantes.Parametros.DISCIPLINA1, this.disciplina1);
        it.putExtra(Constantes.Parametros.DISCIPLINA2, this.disciplina2);
        Toast.makeText(activity, "tela resultado", Toast.LENGTH_SHORT).show();
        activity.startActivity(it);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == Activity.RESULT_OK) {
            if (requestCode == Constantes.Request.DISCIPLINA1){
                Disciplina disciplina =  (Disciplina) data.getSerializableExtra(Constantes.Parametros.DISCIPLINA);
                this.disciplina1 = disciplina;
                Toast.makeText(activity, "Disciplina 1", Toast.LENGTH_SHORT).show();
            } else if (requestCode == Constantes.Request.DISCIPLINA2) {
                Disciplina disciplina =  (Disciplina) data.getSerializableExtra(Constantes.Parametros.DISCIPLINA);
                this.disciplina2 = disciplina;
                Toast.makeText(activity, "Disciplina 2", Toast.LENGTH_SHORT).show();
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(activity, "Ação cancelada", Toast.LENGTH_SHORT).show();
        }
    }
}
