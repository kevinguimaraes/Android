package senac.renato.correcaominhapedida.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import senac.renato.correcaominhapedida.R;
import senac.renato.correcaominhapedida.control.AddProdutoControl;

public class NovoProdutoActivity extends Activity {
    private AddProdutoControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_produto);
        control = new AddProdutoControl(this);
    }

    public void salvarProduto(View v) {
        control.enviarProdutoAction();
    }

    public void addCategoria(View v) {
        control.telaAddNovoProdutoAction();
    }

    @Override
    protected void onResume() {
        super.onResume();
        control.configSpinner();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        control.onActivityResult(requestCode, resultCode, data);
    }
}
