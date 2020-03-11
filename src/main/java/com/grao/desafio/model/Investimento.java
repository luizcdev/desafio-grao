package com.grao.desafio.model;

import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModelProperty;

public class Investimento {
	
	@ApiModelProperty(value = "Valor presente para aplicação")
	@Positive(message = "O valor presente deve ser maior que zero")
	private double valorPresente;
	
	@ApiModelProperty(value = "Quantidade total de semanas da aplicação")
	@Positive(message = "A quantidade de semanas deve ser maior que zero")
	private int semanas;
	
	public double getValorPresente() {
		return valorPresente;
	}
	public void setValorPresente(double valorPresente) {
		this.valorPresente = valorPresente;
	}
	public int getSemanas() {
		return semanas;
	}
	public void setSemanas(int semanas) {
		this.semanas = semanas;
	}
	
		
	
}
