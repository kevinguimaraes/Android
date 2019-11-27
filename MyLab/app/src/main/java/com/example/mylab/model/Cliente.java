package com.example.mylab.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class Cliente implements Serializable{

	@DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;

	@DatabaseField
	private String codigo;

	@DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Pessoa pessoa;

	public Cliente() {
		super();
	}

	public Cliente(String codigo, Pessoa pessoa) {
		super();
		this.codigo = codigo;
		this.pessoa = pessoa;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString(){
		return this.pessoa.getNome();
	}
}
