package com.example.mylab.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;


@DatabaseTable
public class Equipamento implements Serializable{

	@DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
	private Integer id;

	@DatabaseField
    private String nome;

	@DatabaseField
    private String serial;

	@DatabaseField
    private String hw_version;

	@DatabaseField
    private String fw_version;

	public Equipamento(Integer id, String nome, String serial, String hw_version, String fw_version) {
		super();
		this.id = id;
		this.nome = nome;
		this.serial = serial;
		this.hw_version = hw_version;
		this.fw_version = fw_version;
	}

	public Equipamento() {
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

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getHw_version() {
		return hw_version;
	}

	public void setHw_version(String hw_version) {
		this.hw_version = hw_version;
	}

	public String getFw_version() {
		return fw_version;
	}

	public void setFw_version(String fw_version) {
		this.fw_version = fw_version;
	}

	@Override
	public String toString() {
		return this.nome + " v" + this.hw_version;
	}
}
