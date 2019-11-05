package com.example.exemplolistviewpersonalizado.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemplolistviewpersonalizado.R;

import java.util.List;

public class AdapterPessoa extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Pessoa> listPessoas;
    private Context context;

    public AdapterPessoa(List<Pessoa> listPessoas, Context context) {
        this.listPessoas = listPessoas;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listPessoas.size();
    }

    @Override
    public Object getItem(int i) {
        return listPessoas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void add(Pessoa p) {
        listPessoas.add(p);
        this.notifyDataSetChanged();
    }

    public void remove(Pessoa p) {
        listPessoas.remove(p);
        this.notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Pessoa pessoa = listPessoas.get(i);
        view = inflater.inflate(R.layout.item_listview_pessoa, null);

        TextView tvNome = view.findViewById(R.id.tvNome);
        TextView tvIdade = view.findViewById(R.id.tvIdade);
        ImageView ivMaiorIdade = view.findViewById(R.id.ivMaiorIdade);

        tvNome.setText(pessoa.getNome());
        tvIdade.setText(String.valueOf(pessoa.getIdade()));

        if(PessoaBO.isMaiorIdade(pessoa)){
            ivMaiorIdade.setImageResource(R.drawable.maior_idade);
        } else {
            ivMaiorIdade.setImageResource(R.drawable.menor_idade);
        }

        ivMaiorIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PessoaBO.isMaiorIdade(pessoa)){
                    Toast.makeText(context, "Di Maior", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Di Menor", Toast.LENGTH_SHORT).show();
                    remove(pessoa);
                }
            }
        });

        return view;
    }
}
