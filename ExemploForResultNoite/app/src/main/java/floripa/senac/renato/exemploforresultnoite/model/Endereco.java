package floripa.senac.renato.exemploforresultnoite.model;

import java.io.Serializable;

public class Endereco implements Serializable {
    private String cep;
    private String cidade;

    public Endereco() {
    }

    public Endereco(String cep, String cidade) {
        this.cep = cep;
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "CEP: "+cep+"\nCidade: "+cidade;
    }
}
