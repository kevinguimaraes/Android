package senac.renato.correcaominhapedida.dao;

import android.content.Context;

import senac.renato.correcaominhapedida.dao.helpers.DaoHelper;
import senac.renato.correcaominhapedida.model.ItemComanda;

public class ItemComandaDao extends DaoHelper<ItemComanda> {
    public ItemComandaDao(Context c) {
        super(c, ItemComanda.class);
    }
}
