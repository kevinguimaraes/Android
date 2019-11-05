package com.example.exemploviacep.control;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exemploviacep.R;
import com.example.exemploviacep.model.Endereco;
import com.example.exemploviacep.model.EnderecoDTO;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainControl {
    private Activity activity;
    private EditText editCep;
    private EditText editRua;
    private EditText editCidade;
    private EditText editUf;

    public MainControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents(){
        editCep = activity.findViewById(R.id.editCep);
        editRua = activity.findViewById(R.id.editRua);
        editCidade = activity.findViewById(R.id.editCidade);
        editUf = activity.findViewById(R.id.editUf);
    }

    private void desabilitarForm(){
        editRua.setEnabled(false);
        editCidade.setEnabled(false);
        editUf.setEnabled(false);
    }

    private void habilitarForm(){
        editRua.setEnabled(true);
        editCidade.setEnabled(true);
        editUf.setEnabled(true);
    }

    private void limparDados(){
        editRua.setText("");
        editCidade.setText("");
        editUf.setText("");
    }

    private void pesquisarPorCep(String cep){

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://viacep.com.br/ws/" + cep + "/json", new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(activity, "Iniciou", Toast.LENGTH_SHORT).show();
                desabilitarForm();
                editRua.setText("...");
                editUf.setText("...");
                editCidade.setText("...");
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                //Retorno em String do via cep
                String enderecoJson = new String(bytes);

                //Conversão da string json para objeto
                Gson gson = new Gson();

                //Conversão direta
                EnderecoDTO eDTO = gson.fromJson(enderecoJson, EnderecoDTO.class);
                Endereco endereco = eDTO.getEndereco();
                carregarForm(endereco);
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                habilitarForm();
                limparDados();
            }
        });

    }

    private void carregarForm(Endereco e){
        habilitarForm();
        editCidade.setText(e.getCidade());
        editRua.setText(e.getRua());
        editUf.setText(e.getUf());
    }

    public void pesquisarPorCepAction(){
        String cep = editCep.getText().toString();
        pesquisarPorCep(cep);
    }

}
