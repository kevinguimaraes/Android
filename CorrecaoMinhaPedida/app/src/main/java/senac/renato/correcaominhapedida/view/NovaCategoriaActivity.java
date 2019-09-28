package senac.renato.correcaominhapedida.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import senac.renato.correcaominhapedida.R;
import senac.renato.correcaominhapedida.control.AddCategoriaControl;

public class NovaCategoriaActivity extends Activity {
    private AddCategoriaControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_categoria);
        control = new AddCategoriaControl(this);
    }

    public void salvarcategoria(View v) {
        control.enviarCategoriaAction();
    }


}
