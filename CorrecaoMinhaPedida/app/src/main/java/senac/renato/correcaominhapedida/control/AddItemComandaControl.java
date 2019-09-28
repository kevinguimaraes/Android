package senac.renato.correcaominhapedida.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import senac.renato.correcaominhapedida.R;
import senac.renato.correcaominhapedida.dao.CategoriaDao;
import senac.renato.correcaominhapedida.dao.ItemComandaDao;
import senac.renato.correcaominhapedida.dao.ProdutoDao;
import senac.renato.correcaominhapedida.model.Categoria;
import senac.renato.correcaominhapedida.model.ItemComanda;
import senac.renato.correcaominhapedida.model.Produto;
import senac.renato.correcaominhapedida.uteis.Constantes;
import senac.renato.correcaominhapedida.view.NovoProdutoActivity;

public class AddItemComandaControl {
    private Activity activity;

    private Spinner spProduto;
    private List<Produto> listProduto;
    private ArrayAdapter<Produto> adapterProduto;

    private NumberPicker npQuantidade;

    private ProdutoDao produtoDao;
    private CategoriaDao categoriaDao;

    public AddItemComandaControl(Activity activity) {
        this.activity = activity;

        produtoDao = new ProdutoDao(activity);
        categoriaDao = new CategoriaDao(activity);

        initComponents();
    }

    private void initComponents(){
        spProduto = activity.findViewById(R.id.spProduto);
        npQuantidade = activity.findViewById(R.id.npQuantidade);
        configNumberPicker();
        configSpinner();
    }

    private void configNumberPicker(){
        npQuantidade.setMinValue(Constantes.MIN_QUANTIDADE_ITEM);
        npQuantidade.setMaxValue(Constantes.MAX_QUANTIDADE_ITEM);
    }

    private void configSpinner(){
        try {
            categoriaDao.getDao().createIfNotExists(new Categoria(1, "Bebidas"));
            categoriaDao.getDao().createIfNotExists(new Categoria(2, "Alimentos"));
            categoriaDao.getDao().createIfNotExists(new Categoria(3, "Agua"));
            categoriaDao.getDao().createIfNotExists(new Categoria(4, "Fritos"));
            categoriaDao.getDao().createIfNotExists(new Categoria(5, "Petiscos"));
            categoriaDao.getDao().createIfNotExists(new Categoria(6, "Bebidas Alcolicas"));
            produtoDao.getDao().createIfNotExists(new Produto(1, "Refrigerante", 3.00, new Categoria(1, "Bebidas")));
            produtoDao.getDao().createIfNotExists(new Produto(2, "Cerveja", 5.00, new Categoria(6, "Bebidas Alcolicas")));
            produtoDao.getDao().createIfNotExists(new Produto(3, "Batata Frita", 10.00, new Categoria(2, "Alimentos")));
            produtoDao.getDao().createIfNotExists(new Produto(4, "Água", 2.50, new Categoria(3, "Agua")));
            produtoDao.getDao().createIfNotExists(new Produto(5, "Pastel", 3.50, new Categoria(4, "Fritos")));
            produtoDao.getDao().createIfNotExists(new Produto(6,"Petiscos", 6.00, new Categoria(5, "Petiscos")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            listProduto = produtoDao.getDao().queryForAll();
            adapterProduto = new ArrayAdapter<>(
                    activity,
                    android.R.layout.simple_spinner_item,
                    listProduto
            );
            spProduto.setAdapter(adapterProduto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ItemComanda getDadosForm(){
        ItemComanda i = new ItemComanda();
        i.setProduto((Produto) spProduto.getSelectedItem());
        i.setQuantidade(npQuantidade.getValue());
        return i;
    }

    public void enviarItemAction(){
        ItemComanda newItem = getDadosForm();
        Intent it = new Intent();
        it.putExtra(Constantes.PARAM_ITEM_COMANDA, newItem);
        activity.setResult(activity.RESULT_OK, it);
        activity.finish();
    }

    public void telaAddNovoProdutoAction() {
        Intent it = new Intent(activity, NovoProdutoActivity.class);
        activity.startActivityForResult(it, Constantes.REQUEST_NOVO_PRODUTO);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == activity.RESULT_OK){
            if(requestCode==Constantes.REQUEST_NOVO_PRODUTO){
                Produto p = (Produto) data.getSerializableExtra(Constantes.PARAM_NEW_PRODUTO);
                try {
                    if(produtoDao.getDao().create(p)>0) {
                        adapterProduto.add(p);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else if(resultCode==activity.RESULT_CANCELED){
            Toast.makeText(activity, "Ação cancelada", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancelarAction(){
        activity.setResult(activity.RESULT_CANCELED);
        activity.finish();
    }


}
