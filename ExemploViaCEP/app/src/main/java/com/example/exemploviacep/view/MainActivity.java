package com.example.exemploviacep.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.exemploviacep.R;
import com.example.exemploviacep.control.MainControl;

public class MainActivity extends AppCompatActivity {
    private MainControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }

    public void pesquisarCep(View v){
        control.pesquisarPorCepAction();
    }
}
