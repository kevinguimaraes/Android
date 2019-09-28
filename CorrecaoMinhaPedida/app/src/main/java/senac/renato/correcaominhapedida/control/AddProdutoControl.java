package senac.renato.correcaominhapedida.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.sql.SQLException;
import java.util.List;

import senac.renato.correcaominhapedida.R;
import senac.renato.correcaominhapedida.dao.CategoriaDao;
import senac.renato.correcaominhapedida.dao.ProdutoDao;
import senac.renato.correcaominhapedida.model.Categoria;
import senac.renato.correcaominhapedida.model.Produto;
import senac.renato.correcaominhapedida.uteis.Constantes;

public class AddProdutoControl {
    private Activity activity;
    private Spinner spCategoria;
    private List<Categoria> listCategoria;
    private ArrayAdapter<Categoria> adapterCategoria;
    private EditText editNomeProduto;
    private EditText editValor;

    private ProdutoDao produtoDao;
    private CategoriaDao categoriaDao;

    public AddProdutoControl(Activity activity) {
        this.activity = activity;
        produtoDao = new ProdutoDao(activity);
        categoriaDao = new CategoriaDao(activity);
        initComponents();
    }

    private void initComponents() {
        spCategoria = activity.findViewById(R.id.spCategoria);
        editNomeProduto = activity.findViewById(R.id.editNomeProduto);
        editValor = activity.findViewById(R.id.editValor);
        configSpinner();
    }

    private void configSpinner() {
        try {
            categoriaDao.getDao().createIfNotExists(new Categoria(1, "Bebidas"));
            categoriaDao.getDao().createIfNotExists(new Categoria(2, "Alimentos"));
            categoriaDao.getDao().createIfNotExists(new Categoria(3, "Agua"));
            categoriaDao.getDao().createIfNotExists(new Categoria(4, "Fritos"));
            categoriaDao.getDao().createIfNotExists(new Categoria(5, "Petiscos"));
            categoriaDao.getDao().createIfNotExists(new Categoria(6, "Bebidas Alcolicas"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            listCategoria = categoriaDao.getDao().queryForAll();
            adapterCategoria = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, listCategoria);
            spCategoria.setAdapter(adapterCategoria);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Produto getDadosForm(){
        Produto p = new Produto();
        p.setCategoria((Categoria) spCategoria.getSelectedItem());
        p.setNome(editNomeProduto.getText().toString());
        p.setValor(editValor.getText().toString());
        return p;
    }

    public void enviarProdutoAction() {
        Produto p = getDadosForm();
        Intent it = new Intent();
        it.putExtra(Constantes.PARAM_NEW_PRODUTO, p);
        activity.setResult(activity.RESULT_OK, it);
        activity.finish();
    }

    public void cancelarAction() {
        activity.setResult(activity.RESULT_CANCELED);
        activity.finish();
    }
}
