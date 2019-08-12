package com.example.tarefa22.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.tarefa22.R;
import com.example.tarefa22.control.SegundaControl;

public class SegundaActivity extends AppCompatActivity {
    private SegundaControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        control = new SegundaControl(this);
    }

    public void proximo (View v){
        control.proximoAction();
    }
}
