package floripa.senac.renato.exemploforresultnoite.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import floripa.senac.renato.exemploforresultnoite.R;
import floripa.senac.renato.exemploforresultnoite.control.EnderecoControl;
import floripa.senac.renato.exemploforresultnoite.model.Endereco;

public class EnderecoActivity extends AppCompatActivity {
    private EnderecoControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);
        control = new EnderecoControl(this);
    }

    public void enviar(View v){
        control.enviarAction();
    }

    public void cancelar(View v){
        control.cancelarAction();
    }
}