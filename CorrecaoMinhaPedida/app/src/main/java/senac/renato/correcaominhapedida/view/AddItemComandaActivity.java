package senac.renato.correcaominhapedida.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import senac.renato.correcaominhapedida.R;
import senac.renato.correcaominhapedida.control.AddItemComandaControl;

public class AddItemComandaActivity extends Activity {
    private AddItemComandaControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_comanda);
        control = new AddItemComandaControl(this);
    }

    public void enviarItem(View v){
        control.enviarItemAction();
    }

    public void cancelar(View v){
        control.cancelarAction();
    }

    public void novoProduto(View v) {
        control.telaAddNovoProdutoAction();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        control.onActivityResult(requestCode, resultCode, data);
    }
}
