package com.example.provakevin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.provakevin.R;
import com.example.provakevin.control.ConfigDado;

public class ClienteActivity extends AppCompatActivity {
    private ConfigDado control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        control = new ConfigDado(this);
    }

    public void enviar(View v) {
        control.enviarAction();
    }

    public void cancelar(View v){
        control.cancelarAction();
    }
}
