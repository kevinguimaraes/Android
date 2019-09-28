package senac.renato.correcaominhapedida.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import senac.renato.correcaominhapedida.R;
import senac.renato.correcaominhapedida.dao.CategoriaDao;
import senac.renato.correcaominhapedida.model.Categoria;
import senac.renato.correcaominhapedida.uteis.Constantes;

public class AddCategoriaControl {
    private Activity activity;
    private ListView lvCategoria;
    private EditText editCategoria;
    private List<Categoria> listCategoria;
    private ArrayAdapter<Categoria> adapterCategoria;

    private Categoria categoria;
    private CategoriaDao categoriaDao;

    public AddCategoriaControl(Activity activity) {
        this.activity = activity;
        categoriaDao = new CategoriaDao(activity);
        initComponents();
    }

    private void initComponents() {
        lvCategoria = activity.findViewById(R.id.lvCategoria);
        editCategoria = activity.findViewById(R.id.editCategoria);
        configListView();
    }

    private void configListView() {
        try {
            listCategoria = categoriaDao.getDao().queryForAll();
        } catch (SQLException e) {
            listCategoria = new ArrayList<>();
        }
        adapterCategoria = new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1, listCategoria);
        lvCategoria.setAdapter(adapterCategoria);
    }

    private Categoria getDadosForm() {
        Categoria c = new Categoria();
        c.setNome(editCategoria.getText().toString());
        return c;
    }

    public void enviarCategoriaAction(){
        Categoria c = getDadosForm();
        Intent it = new Intent();
        it.putExtra(Constantes.PARAM_NEW_CATEGORIA, c);
        activity.setResult(activity.RESULT_OK, it);
        activity.finish();
    }
}
