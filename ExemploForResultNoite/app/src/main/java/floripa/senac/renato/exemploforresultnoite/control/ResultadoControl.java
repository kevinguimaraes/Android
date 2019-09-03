package floripa.senac.renato.exemploforresultnoite.control;

import android.app.Activity;
import android.widget.TextView;

import floripa.senac.renato.exemploforresultnoite.R;
import floripa.senac.renato.exemploforresultnoite.model.Pessoa;
import floripa.senac.renato.exemploforresultnoite.uteis.Constantes;

public class ResultadoControl {
    private Activity activity;
    private TextView tvResultado;

    public ResultadoControl(Activity activity) {
        this.activity = activity;
        initComponents();
        showResultado();
    }
    private void initComponents(){
        tvResultado = activity.findViewById(R.id.tvResultado);
    }

    private void showResultado(){
        Pessoa p = (Pessoa) activity.getIntent().getSerializableExtra(
                Constantes.Parametros.PESSOA
        );
        tvResultado.setText(p.toString());
    }
}
