package floripa.senac.renato.exemploforresultnoite.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import floripa.senac.renato.exemploforresultnoite.R;
import floripa.senac.renato.exemploforresultnoite.model.Endereco;
import floripa.senac.renato.exemploforresultnoite.model.Pessoa;
import floripa.senac.renato.exemploforresultnoite.model.PessoaBO;
import floripa.senac.renato.exemploforresultnoite.uteis.Constantes;

public class EnderecoControl {
    private Activity activity;
    private EditText editCep;
    private EditText editCidade;

    public EnderecoControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    public void initComponents(){
        editCep = activity.findViewById(R.id.editCep);
        editCidade = activity.findViewById(R.id.editCidade);
        carregarForm();
    }

    public void carregarForm(){
        Endereco e = (Endereco) activity.getIntent().getSerializableExtra(
                Constantes.Parametros.ENDERECO
        );
        editCep.setText(e.getCep());
        editCidade.setText(e.getCidade());
    }

    private boolean valida(Endereco e){
        if(!PessoaBO.validaCep(e)){
            editCep.setError("CEP inválido");
            editCep.requestFocus();
            return false;
        }
        if(!PessoaBO.validaCidade(e)){
            editCidade.setError("Cidade inválida");
            editCidade.requestFocus();
            return false;
        }
        return true;
    }

    private Endereco getDadosForm(){
        Endereco e = new Endereco();
        e.setCep(editCep.getText().toString());
        e.setCidade(editCidade.getText().toString());
        return e;
    }

    public void enviarAction(){
        Endereco e = getDadosForm();
        if(valida(e)){
            Intent it = new Intent();
            it.putExtra(Constantes.Parametros.ENDERECO, e);
            activity.setResult(activity.RESULT_OK, it);
            activity.finish();
        }
    }

    public void cancelarAction(){
        activity.setResult(activity.RESULT_CANCELED);
        activity.finish();
    }
}
