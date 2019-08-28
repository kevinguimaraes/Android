package com.example.exemploforresult.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.exemploforresult.R;
import com.example.exemploforresult.control.ContatoControl;

public class ContatoActivity extends AppCompatActivity {

    private ContatoControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
    }

    public void enviar(View v){
        control.enviarAction();
    }

    public void cancelar(View v) {
        control.cancelarAction();
    }
}
