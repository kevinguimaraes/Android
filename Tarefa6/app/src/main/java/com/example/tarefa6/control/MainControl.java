package com.example.tarefa6.control;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tarefa6.R;
import com.example.tarefa6.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class MainControl {
    private Activity activity;
    private TextView tvTotal;
    private ListView lvPedido;
    private List<Produto> listProduto;
    private ArrayAdapter<Produto> adapterProduto;
    private Produto produto;

    public MainControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        this.tvTotal = activity.findViewById(R.id.tvTotal);
        this.lvPedido = activity.findViewById(R.id.lvPedido);
        configListView();
    }

    private void configListView() {
        this.listProduto = new ArrayList<>();
        this.listProduto.add(new Produto("Maçã", 1.20, 0));
        this.listProduto.add(new Produto("Pera", 2.50, 0));
        this.adapterProduto = new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1);
        this.lvPedido.setAdapter(this.adapterProduto);
        this.adapterProduto.add(new Produto("Banana", 5.30, 0));
        cliqueCurto();
        cliqueLongo();
    }

    private void addProdutoLv(Produto p){
        adapterProduto.add(p);
    }

    private void deleteProdutoLv(Produto p) {
        adapterProduto.remove(p);
    }

    private void atualizaProdutoLv(Produto p) {
        this.produto.setNome(p.getNome());
        this.produto.setQuantidae(p.getQuantidae());
        this.produto.setValor(p.getValor());
        this.adapterProduto.notifyDataSetChanged();
    }

    private Produto getDados() {
        Produto p = new Produto();
        p.setNome(this.produto.getNome());
        p.setValor(this.produto.getValor());
        p.setQuantidae(this.produto.getQuantidae());
        return p;
    }


}
