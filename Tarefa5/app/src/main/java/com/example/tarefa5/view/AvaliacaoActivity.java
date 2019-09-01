package com.example.tarefa5.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tarefa5.R;
import com.example.tarefa5.control.DisciplinaControl;

public class AvaliacaoActivity extends AppCompatActivity {
    private DisciplinaControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        control = new DisciplinaControl(this);
        setContentView(R.layout.activity_avaliacao);
    }

    public void enviar(View v){
        control.enviarAction();
    }

    public void cancelar(View v) {
        control.cancelarAction();
    }
}
