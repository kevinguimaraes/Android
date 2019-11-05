package com.example.exemplolistviewpersonalizado.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.exemplolistviewpersonalizado.R;
import com.example.exemplolistviewpersonalizado.control.MainControl;

public class MainActivity extends AppCompatActivity {
    private MainControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }

    public void salvar(View v){
        control.salvarAction();
    }
}
