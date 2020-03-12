package com.grao.desafio.model;

import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModelProperty;

public class Investimento {
	
	@ApiModelProperty(value = "Valor do aporte semanal para aplicação")
	@Positive(message = "O valor do aporte deve ser maior que zero")
	private double valorAporte;
	
	@ApiModelProperty(value = "Quantidade total de semanas da aplicação")
	@Positive(message = "A quantidade de semanas deve ser maior que zero")
	private int semanas;
	
	
	public double getValorAporte() {
		return valorAporte;
	}
	public void setValorAporte(double valorAporte) {
		this.valorAporte = valorAporte;
	}
	
	public int getSemanas() {
		return semanas;
	}
	public void setSemanas(int semanas) {
		this.semanas = semanas;
	}
	
		
	
}
