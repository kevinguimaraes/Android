package floripa.senac.renato.exemploforresultnoite.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import floripa.senac.renato.exemploforresultnoite.R;
import floripa.senac.renato.exemploforresultnoite.control.ResultadoControl;

public class ResultadoActivity extends AppCompatActivity {
    private ResultadoControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        control = new ResultadoControl(this);
    }
}
