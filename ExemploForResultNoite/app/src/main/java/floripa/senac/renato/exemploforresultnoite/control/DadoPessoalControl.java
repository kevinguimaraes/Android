package floripa.senac.renato.exemploforresultnoite.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import floripa.senac.renato.exemploforresultnoite.R;
import floripa.senac.renato.exemploforresultnoite.model.DadoPessoal;
import floripa.senac.renato.exemploforresultnoite.model.PessoaBO;
import floripa.senac.renato.exemploforresultnoite.uteis.Constantes;

public class DadoPessoalControl {
    private Activity activity;
    private EditText editNome;
    private EditText editIdade;

    public DadoPessoalControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents(){
        editNome = activity.findViewById(R.id.editNome);
        editIdade = activity.findViewById(R.id.editIdade);
        carregarForm();
    }

    private void carregarForm(){
        DadoPessoal d = (DadoPessoal) activity.getIntent().getSerializableExtra(
                Constantes.Parametros.DADO_PESSOAL
        );
        editNome.setText(d.getNome());

        if(d.getIdade()!=null)
            editIdade.setText(d.getIdade().toString());
    }

    private DadoPessoal getDadosForm(){
        DadoPessoal d = new DadoPessoal();
        d.setNome(editNome.getText().toString());
        d.setIdade(editIdade.getText().toString());
        return d;
    }

    private boolean valida(DadoPessoal d){
        if(!PessoaBO.validaNome(d)){
            editNome.setError("Nome inválido");
            editNome.requestFocus();
            return false;
        }
        if(!PessoaBO.validaIdade(d)){
            editIdade.setError("Idade inválida");
            editIdade.requestFocus();
            return false;
        }
        return true;
    }



    public void enviarAction(){
        DadoPessoal d = getDadosForm();
        if(valida(d)){
            Intent it = new Intent();
            it.putExtra(Constantes.Parametros.DADO_PESSOAL,d);
            activity.setResult(activity.RESULT_OK, it);
            activity.finish();
        }
    }

    public void cancelarAction(){
        activity.setResult(activity.RESULT_CANCELED);
        activity.finish();
    }

}
