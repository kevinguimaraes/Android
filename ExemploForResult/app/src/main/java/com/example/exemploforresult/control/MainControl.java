package com.example.exemploforresult.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemploforresult.R;
import com.example.exemploforresult.model.DadoPessoal;
import com.example.exemploforresult.model.Endereco;
import com.example.exemploforresult.model.Pessoa;
import com.example.exemploforresult.uteis.Constantes;
import com.example.exemploforresult.view.EnderecoActivity;

public class MainControl {
    private Activity activity;
    private Pessoa pessoa;
    private TextView tvTeste;

    public MainControl(Activity activity) {
        this.activity = activity;
        this.pessoa = new Pessoa();

        this.tvTeste = activity.findViewById(R.id.tvTeste);
    }

    public void telaEnderecoAction(){
        Intent it = new Intent(activity, EnderecoActivity.class);
        it.putExtra(Constantes.Parametros.ENDERECO, pessoa.getEndereco());
        activity.startActivityForResult(it, Constantes.Request.ENDERECO);
    }

    public void telaDadoPessoalAction(){

    }

    public void telaResultadoAction() {

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == activity.RESULT_OK) {
            if (requestCode == Constantes.Request.ENDERECO){
                Endereco endereco =  (Endereco) data.getSerializableExtra(Constantes.Parametros.ENDERECO);
                this.pessoa.setEndereco(endereco);
                this.tvTeste.setText(endereco.toString());
            } else if (requestCode == Constantes.Request.DADO_PESSOAL) {
                DadoPessoal dadoPessoal = (DadoPessoal) data.getSerializableExtra(Constantes.Parametros.DADO_PESSOAL);
                this.pessoa.setDadoPessoal(dadoPessoal);
                this.tvTeste.setText(dadoPessoal.toString());
            }
        } else if (resultCode == activity.RESULT_CANCELED) {
            Toast.makeText(activity, "Ação cancelada", Toast.LENGTH_SHORT).show();
        }
    }
}
