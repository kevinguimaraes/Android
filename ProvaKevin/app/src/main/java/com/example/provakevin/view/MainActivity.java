package com.example.provakevin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.provakevin.R;
import com.example.provakevin.control.ConfigControl;

public class MainActivity extends AppCompatActivity {
    private ConfigControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new ConfigControl(this);
    }

    public void enviar(View v) {
        control.enviarAction();
    }

    public void fechar(View v ){
        control.cancelarAction();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        control.onActivityResult(requestCode, resultCode, data);
    }
}
