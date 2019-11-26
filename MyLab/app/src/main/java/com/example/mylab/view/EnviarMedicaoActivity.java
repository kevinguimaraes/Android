package com.example.mylab.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mylab.R;
import com.example.mylab.control.EnviarControl;

import java.text.ParseException;

public class EnviarMedicaoActivity extends AppCompatActivity {
    private EnviarControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_medicao);
        this.control = new EnviarControl(this);
    }

    public void enviar(View v){
        control.enviarAction();
    }
}
