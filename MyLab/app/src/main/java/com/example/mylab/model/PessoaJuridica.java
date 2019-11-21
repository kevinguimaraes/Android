package com.example.mylab.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;


@DatabaseTable
public class PessoaJuridica extends Pessoa implements Serializable{

	@DatabaseField
	private String cnpj;

	@DatabaseField
	private String fantasia;

	public PessoaJuridica() {
	}

	public PessoaJuridica(String cnpj, String fantasia) {
		this.cnpj = cnpj;
		this.fantasia = fantasia;
	}
	

	public PessoaJuridica(Integer id, String nome, Date dt_nascimento, String telefone, String email, String cnpj, String fantasia) {
		super(id, nome, dt_nascimento, telefone, email);
		this.cnpj = cnpj;
		this.fantasia = fantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

}
