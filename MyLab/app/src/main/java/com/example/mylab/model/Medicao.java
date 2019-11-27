package com.example.mylab.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;


@DatabaseTable
public class Medicao implements Serializable{

	@DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer id;

	@DatabaseField
    private double valor;

	@DatabaseField
    private String unidade;

	@DatabaseField(dataType = DataType.DATE)
    private Date dt_Medicao;

	@DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Equipamento equipamento;

	@DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Amostra amostra;

	public Medicao(Integer id, double valor, String unidade, Date dt_Medicao, Equipamento equipamento, Amostra amostra) {
		super();
		this.id = id;
		this.valor = valor;
		this.unidade = unidade;
		this.dt_Medicao = dt_Medicao;
		this.equipamento = equipamento;
		this.amostra = amostra;
	}

	public Medicao() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Date getDt_Medicao() {
		return dt_Medicao;
	}

	public void setDt_Medicao(Date dt_Medicao) {
		this.dt_Medicao = dt_Medicao;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public void setAmostra(Amostra amostra) {
		this.amostra = amostra;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public Amostra getAmostra() {
		return amostra;
	}

	@Override
	public String toString(){
		return this.valor + " " + this.unidade;
	}
}
