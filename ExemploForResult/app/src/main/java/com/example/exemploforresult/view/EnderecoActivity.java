package com.example.exemploforresult.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.exemploforresult.R;
import com.example.exemploforresult.control.EnderecoControl;

public class EnderecoActivity extends AppCompatActivity {

    private EnderecoControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);
    }

    public void enviar(View v){
        control.enviarAction();
    }

    public void cancelar(View v) {
        control.cancelarAction();
    }
}
