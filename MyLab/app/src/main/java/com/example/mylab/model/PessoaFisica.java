package com.example.mylab.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;

@DatabaseTable
public class PessoaFisica extends Pessoa implements Serializable{

	@DatabaseField
	private String cpf;

	@DatabaseField
	private String genero;

	public PessoaFisica() {
	}

	public PessoaFisica(String cpf, String genero) {
		super();
		this.cpf = cpf;
		this.genero = genero;
	}
	
	public PessoaFisica(Integer id, String nome, Date dt_nascimento, String telefone, String email, String cpf, String genero) {
		super(id, nome, dt_nascimento, telefone, email);
		this.cpf = cpf;
		this.genero = genero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}


}
