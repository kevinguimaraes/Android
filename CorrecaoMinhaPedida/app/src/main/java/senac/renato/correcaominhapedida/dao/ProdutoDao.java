package senac.renato.correcaominhapedida.dao;

import android.content.Context;

import senac.renato.correcaominhapedida.dao.helpers.DaoHelper;
import senac.renato.correcaominhapedida.model.Produto;

public class ProdutoDao extends DaoHelper<Produto> {
    public ProdutoDao(Context c) {
        super(c, Produto.class);
    }
}
