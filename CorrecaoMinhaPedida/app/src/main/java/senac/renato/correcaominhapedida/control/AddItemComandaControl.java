package senac.renato.correcaominhapedida.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import senac.renato.correcaominhapedida.R;
import senac.renato.correcaominhapedida.dao.ItemComandaDao;
import senac.renato.correcaominhapedida.dao.ProdutoDao;
import senac.renato.correcaominhapedida.model.ItemComanda;
import senac.renato.correcaominhapedida.model.Produto;
import senac.renato.correcaominhapedida.uteis.Constantes;

public class AddItemComandaControl {
    private Activity activity;

    private Spinner spProduto;
    private List<Produto> listProduto;
    private ArrayAdapter<Produto> adapterProduto;

    private NumberPicker npQuantidade;

    private ProdutoDao produtoDao;

    public AddItemComandaControl(Activity activity) {
        this.activity = activity;

        produtoDao = new ProdutoDao(activity);

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
            produtoDao.getDao().createIfNotExists(new Produto(1, "Refrigerante", 3.00));
            produtoDao.getDao().createIfNotExists(new Produto(2, "Cerveja", 5.00));
            produtoDao.getDao().createIfNotExists(new Produto(3, "Batata Frita", 10.00));
            produtoDao.getDao().createIfNotExists(new Produto(4, "Água", 2.50));
            produtoDao.getDao().createIfNotExists(new Produto(5, "Pastel", 3.50));
            produtoDao.getDao().createIfNotExists(new Produto(6,"Petiscos", 6.00));
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

    public void cancelarAction(){
        activity.setResult(activity.RESULT_CANCELED);
        activity.finish();
    }


}
