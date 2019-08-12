package com.example.tarefa1.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tarefa1.R;
import com.example.tarefa1.control.MainControl;


public class MainActivity extends AppCompatActivity {
    private MainControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }

    public void salvar(View v) {
        control.salvarAction();
    }

    public void limpar(View v) {
        control.limparAction();
    }
}
