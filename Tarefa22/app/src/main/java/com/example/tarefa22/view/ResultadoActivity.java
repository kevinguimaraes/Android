package com.example.tarefa22.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tarefa22.R;
import com.example.tarefa22.control.ResultadoControl;

public class ResultadoActivity extends AppCompatActivity {
    private ResultadoControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        control = new ResultadoControl(this);
    }
}
