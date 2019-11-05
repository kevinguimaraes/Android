package com.example.exemplolistviewpersonalizado.control;

import android.app.Activity;
import android.widget.EditText;
import android.widget.ListView;

import com.example.exemplolistviewpersonalizado.R;
import com.example.exemplolistviewpersonalizado.model.AdapterPessoa;
import com.example.exemplolistviewpersonalizado.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class MainControl {
    private Activity activity;
    private EditText editNome;
    private EditText editIdade;
    private ListView lvPessoas;

    private List<Pessoa> listPessoas;
    private AdapterPessoa adapterPessoa;

    public MainControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        editNome = activity.findViewById(R.id.editNome);
        editIdade = activity.findViewById(R.id.editIdade);
        lvPessoas = activity.findViewById(R.id.lvPessoas);
        configListView();
    }

    private void configListView() {
        listPessoas = new ArrayList<>();
        listPessoas.add(new Pessoa("Jose", 59));
        listPessoas.add(new Pessoa("Joao", 12));
        listPessoas.add(new Pessoa("Ana", 18));
        adapterPessoa = new AdapterPessoa(listPessoas, activity);
        lvPessoas.setAdapter(adapterPessoa);
    }

    public void salvarAction() {
        Pessoa p = new Pessoa();
        p.setNome(editNome.getText().toString());
        p.setIdade(editIdade.getText().toString());
        adapterPessoa.add(p);
    }
}
