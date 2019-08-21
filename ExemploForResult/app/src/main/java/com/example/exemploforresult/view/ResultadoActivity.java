package com.example.exemploforresult.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.exemploforresult.R;
import com.example.exemploforresult.control.ResultadoControl;

public class ResultadoActivity extends AppCompatActivity {
    private ResultadoControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        control = new ResultadoControl(this);
    }
}
