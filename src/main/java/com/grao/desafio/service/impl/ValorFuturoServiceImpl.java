package com.grao.desafio.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.grao.desafio.model.Investimento;
import com.grao.desafio.service.ValorFuturoService;

@Service
public class ValorFuturoServiceImpl implements ValorFuturoService {

	@Override
	public double calculo(Investimento investimento) throws Exception {
		
		final double TAXA_SELIC_ANUAL = 0.0425;
		final double DIAS_UTEIS_ANO = 252;
		final double DIAS_UTEIS_SEMANA = 5;
		
		double diasInvestimento = investimento.getSemanas() * DIAS_UTEIS_SEMANA;
		double prazo = (diasInvestimento/DIAS_UTEIS_ANO);
		double valorFuturo = investimento.getValorPresente() * Math.pow((1 + TAXA_SELIC_ANUAL),  prazo);
		
		BigDecimal decimal = new BigDecimal(valorFuturo);
		return decimal.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
	}

}
