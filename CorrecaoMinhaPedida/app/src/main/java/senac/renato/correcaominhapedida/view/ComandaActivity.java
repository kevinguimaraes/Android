package senac.renato.correcaominhapedida.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import senac.renato.correcaominhapedida.R;
import senac.renato.correcaominhapedida.control.ComandaControl;

public class ComandaActivity extends Activity {
    private ComandaControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comanda);
        control = new ComandaControl(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        control.configListView();
    }

    public void telaAddItemComanda(View v){
        control.telaAddItemComandaAction();
    }

    public void limparLista(View v){
        control.limparListAction();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        control.onActivityResult(requestCode, resultCode, data);
    }
}
