package floripa.senac.renato.exemploforresultnoite.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import floripa.senac.renato.exemploforresultnoite.R;
import floripa.senac.renato.exemploforresultnoite.control.MainControl;

public class MainActivity extends AppCompatActivity {
    private MainControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }

    public void telaEndereco(View v){
        control.telaEnderecoAction();
    }

    public void telaDadoPessoal(View v){
        control.telaDadoPessoalAction();
    }

    public void telaResultado(View v){
        control.telaResultadoAction();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        control.onActivityResult(requestCode, resultCode, data);
    }
}
