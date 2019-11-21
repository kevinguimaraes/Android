package com.example.mylab.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mylab.R;
import com.example.mylab.control.CadastrarControl;

public class CadastrarActivity extends AppCompatActivity {
    private CadastrarControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        control = new CadastrarControl(this);
    }

    public void enviar(View v){
        control.enviarAction();
    }


}
