package com.example.tarefa5.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tarefa5.R;
import com.example.tarefa5.control.MainControl;

public class MainActivity extends AppCompatActivity {
    private MainControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }

    public void avaliacao1(View v){
        control.telaDisciplina1Action();
    }

    public void avaliacao2(View v){
        control.telaDisciplina2Action();
    }

    public void resultado(View v) {
        control.telaResultadoAction();
    }


}
