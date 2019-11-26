package com.example.mylab.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mylab.R;
import com.example.mylab.control.VisualizarControl;

public class VisualizarMedidaActivity extends AppCompatActivity {
    private VisualizarControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_medida);
        control = new VisualizarControl(this);
    }
}
