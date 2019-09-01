package com.example.tarefa5.control;

import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tarefa5.R;
import com.example.tarefa5.Uteis.Constantes;
import com.example.tarefa5.model.Disciplina;
import com.example.tarefa5.model.DisciplinaBo;

public class ResultadoControl {
    private Activity activity;
    private TextView tvA1Disciplina;
    private TextView tvA1Nota1;
    private TextView tvA1Nota2;
    private TextView tvA1Media;
    private TextView tvA2Disciplina;
    private TextView tvA2Nota1;
    private TextView tvA2Nota2;
    private TextView tvA2Media;

    public ResultadoControl(Activity activity) {
        this.activity = activity;
        initComponents();
        showResult();
    }

    private void showResult() {
        Disciplina d1 = (Disciplina) activity.getIntent().getSerializableExtra(Constantes.Parametros.DISCIPLINA1);
        Disciplina d2 = (Disciplina) activity.getIntent().getSerializableExtra(Constantes.Parametros.DISCIPLINA2);
        DisciplinaBo db = new DisciplinaBo(d1);
        this.tvA1Disciplina.setText(this.tvA1Disciplina.getText().toString() + d1.getNome());
        this.tvA1Nota1.setText(this.tvA1Nota1.getText().toString() + d1.getNota1());
        this.tvA1Nota2.setText(this.tvA1Nota2.getText().toString() + d1.getNota2());
        this.tvA1Media.setText(this.tvA1Media.getText().toString() + db.getMedia());

        db = new DisciplinaBo(d1);
        this.tvA2Disciplina.setText(this.tvA2Disciplina.getText().toString() + d2.getNome());
        this.tvA2Nota1.setText(this.tvA2Nota1.getText().toString() + d2.getNota1());
        this.tvA2Nota2.setText(this.tvA2Nota2.getText().toString() + d2.getNota2());
        this.tvA2Media.setText(this.tvA2Media.getText().toString() + db.getMedia());
    }

    private void initComponents() {
        this.tvA1Disciplina = activity.findViewById(R.id.tvA1Disciplina);
        this.tvA1Nota1 = activity.findViewById(R.id.tvA1Nota1);
        this.tvA1Nota2 = activity.findViewById(R.id.tvA1Nota2);
        this.tvA1Media = activity.findViewById(R.id.tvA1Media);
        this.tvA2Disciplina = activity.findViewById(R.id.tvA2Disciplina);
        this.tvA2Nota1 = activity.findViewById(R.id.tvA2Nota1);
        this.tvA2Nota2 = activity.findViewById(R.id.tvA2Nota2);
        this.tvA2Media = activity.findViewById(R.id.tvA2Media);
        Toast.makeText(activity, "tela res result", Toast.LENGTH_SHORT).show();
    }


}
