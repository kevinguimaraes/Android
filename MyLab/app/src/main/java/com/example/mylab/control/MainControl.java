package com.example.mylab.control;

import android.app.Activity;
import android.content.Intent;

import com.example.mylab.view.CadastrarActivity;
import com.example.mylab.view.EnviarMedicaoActivity;
import com.example.mylab.view.VisualizarMedidaActivity;

public class MainControl {
    private Activity activity;

    public MainControl(Activity activity) {
        this.activity = activity;
    }

    public void cadastrarAction(){
        Intent it = new Intent(activity, CadastrarActivity.class);
        activity.startActivity(it);
    }

    public void enviarAction(){
        Intent it = new Intent(activity, EnviarMedicaoActivity.class);
        activity.startActivity(it);
    }

    public void visualizarAction(){
        Intent it = new Intent(activity, VisualizarMedidaActivity.class);
        activity.startActivity(it);
    }

}
