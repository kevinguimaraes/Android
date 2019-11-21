package com.example.mylab.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mylab.R;
import com.example.mylab.control.MainControl;
import com.example.mylab.dao.EquipamentoDao;
import com.example.mylab.model.Equipamento;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {
    MainControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }

    public void cadastrar(View v){
        control.cadastrarAction();
    }

    public void enviar(View v){
        control.enviarAction();
    }

    public void visualizar(View v){
        control.visualizarAction();
    }
}
