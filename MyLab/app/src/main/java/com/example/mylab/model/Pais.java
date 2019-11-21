package com.example.mylab.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class Pais implements Serializable{

	@DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
	private Integer id;

    @DatabaseField
    private String nome;


	public Pais(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Pais() {
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


}
