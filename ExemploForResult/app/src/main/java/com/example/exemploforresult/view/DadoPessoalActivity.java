package com.example.exemploforresult.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.exemploforresult.R;
import com.example.exemploforresult.control.DadoPessoalControl;

public class DadoPessoalActivity extends AppCompatActivity {
    private DadoPessoalControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dado_pessoal);
        control = new DadoPessoalControl(this);
    }

    public void enviar(View v){
        control.enviarAction();
    }

    public void cancelar(View v) {
        control.cancelarAction();
    }
}
