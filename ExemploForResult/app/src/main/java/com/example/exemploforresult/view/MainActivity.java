package com.example.exemploforresult.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.exemploforresult.R;
import com.example.exemploforresult.control.MainControl;

public class MainActivity extends AppCompatActivity {
    private MainControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }

    public void telaDadoPessoal(View v){
        control.telaDadoPessoalAction();
    }

    public void telaEndereco(View v){
        control.telaEnderecoAction();
    }

    public void telaResultado(View v){
        control.telaResultadoAction();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        control.onActivityResult(requestCode, resultCode, data);
    }
}
