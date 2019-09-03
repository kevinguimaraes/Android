package floripa.senac.renato.exemploforresultnoite.model;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private DadoPessoal dadoPessoal;
    private Endereco endereco;

    public Pessoa() {
        dadoPessoal = new DadoPessoal();
        endereco = new Endereco();
    }

    public Pessoa(DadoPessoal dadoPessoal, Endereco endereco) {
        this.dadoPessoal = dadoPessoal;
        this.endereco = endereco;
    }

    public DadoPessoal getDadoPessoal() {
        return dadoPessoal;
    }

    public void setDadoPessoal(DadoPessoal dadoPessoal) {
        this.dadoPessoal = dadoPessoal;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return dadoPessoal.toString()+"\n"
                + endereco.toString();
    }
}
