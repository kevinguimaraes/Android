package com.example.mylab.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;


@DatabaseTable
public class Estado implements Serializable{

	@DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
	private Integer id;

	@DatabaseField
    private String nome;

	@DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Pais pais;
    
	public Estado(Integer id, String nome, Pais pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.pais = pais;
	}

	public Estado() {
		super();
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
	
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}


}
