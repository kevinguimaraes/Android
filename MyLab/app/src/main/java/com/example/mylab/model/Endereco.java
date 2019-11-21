package com.example.mylab.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;


@DatabaseTable
public class Endereco implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;

    @DatabaseField
    private String logradouro;

    @DatabaseField
    private Integer numero;

    @DatabaseField
    private String complemento;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Cidade cidade;
    
    public Endereco() {
    }

    

    public Endereco(Integer id, String logradouro, Integer numero, String complemento, Cidade cidade) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    
    
	public Integer getNumero() {
		return numero;
	}



	public void setNumero(Integer numero) {
		this.numero = numero;
	}



	public String getComplemento() {
		return complemento;
	}



	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}



	public Cidade getCidade() {
		return cidade;
	}



	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


}
