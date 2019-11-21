package com.example.mylab.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;


@DatabaseTable
public class Pessoa implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;

    @DatabaseField
    private String nome;

    @DatabaseField(dataType = DataType.DATE)
    private Date dt_nascimento;

    @DatabaseField
    private String telefone;

    @DatabaseField
    private String email;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Endereco endereco;
    
    
    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, Date dt_nascimento, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.dt_nascimento = dt_nascimento;
		this.telefone = telefone;
		this.email = email;
	}

	public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
