package com.example.mylab.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;


@DatabaseTable
public class Amostra implements Serializable{

	@DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;

	@DatabaseField
    private String codigo;

	@DatabaseField
    private Date dt_amostra;

	@DatabaseField
    private String observacao;

	@DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Cliente cliente;

	@DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Endereco endereco;

	public Amostra(Integer id, String codigo, Date dt_amostra, String observacao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.dt_amostra = dt_amostra;
		this.observacao = observacao;
	}

	public Amostra() {
		super();
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

	public Date getDt_amostra() {
		return dt_amostra;
	}

	public void setDt_amostra(Date dt_amostra) {
		this.dt_amostra = dt_amostra;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString(){
		return this.codigo + " - " + this.dt_amostra;
	}

}
