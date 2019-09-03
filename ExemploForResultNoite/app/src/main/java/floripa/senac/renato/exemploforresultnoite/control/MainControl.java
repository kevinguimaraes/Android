package floripa.senac.renato.exemploforresultnoite.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import floripa.senac.renato.exemploforresultnoite.R;
import floripa.senac.renato.exemploforresultnoite.model.DadoPessoal;
import floripa.senac.renato.exemploforresultnoite.model.Endereco;
import floripa.senac.renato.exemploforresultnoite.model.Pessoa;
import floripa.senac.renato.exemploforresultnoite.uteis.Constantes;
import floripa.senac.renato.exemploforresultnoite.view.DadoPessoalActivity;
import floripa.senac.renato.exemploforresultnoite.view.EnderecoActivity;
import floripa.senac.renato.exemploforresultnoite.view.ResultadoActivity;

public class MainControl {
    private Activity activity;
    private Pessoa pessoa;
    private TextView tvTeste;

    public MainControl(Activity activity) {
        this.activity = activity;
        pessoa = new Pessoa();

        tvTeste = activity.findViewById(R.id.tvTeste);
    }

    public void telaEnderecoAction(){
        Intent it = new Intent(activity, EnderecoActivity.class);
        it.putExtra(Constantes.Parametros.ENDERECO, pessoa.getEndereco());
        activity.startActivityForResult(it, Constantes.Request.ENDERECO);
    }

    public void telaDadoPessoalAction(){
        Intent it = new Intent(activity, DadoPessoalActivity.class);
        it.putExtra(Constantes.Parametros.DADO_PESSOAL, pessoa.getDadoPessoal());
        activity.startActivityForResult(it, Constantes.Request.DADO_PESSOAL);
    }

    public void telaResultadoAction(){
        Intent it = new Intent(activity, ResultadoActivity.class);
        it.putExtra(Constantes.Parametros.PESSOA, pessoa);
        activity.startActivity(it);
    }

    public void onActivityResult(int requestCode,
                                 int resultCode,
                                 Intent data){

        if(resultCode==activity.RESULT_OK) {
            if (requestCode == Constantes.Request.ENDERECO) {
                Endereco endereco = (Endereco) data.getSerializableExtra(
                        Constantes.Parametros.ENDERECO);
                pessoa.setEndereco(endereco);

                //Saida de teste
                tvTeste.setText(endereco.toString());
            } else if (requestCode == Constantes.Request.DADO_PESSOAL) {
                DadoPessoal dadoPessoal = (DadoPessoal) data.getSerializableExtra(
                        Constantes.Parametros.DADO_PESSOAL);
                pessoa.setDadoPessoal(dadoPessoal);

                //Saida de teste
                tvTeste.setText(dadoPessoal.toString());
            }
        }else if(resultCode==activity.RESULT_CANCELED){
            Toast.makeText(activity, "Ação cancelada", Toast.LENGTH_SHORT).show();
        }

    }
}
