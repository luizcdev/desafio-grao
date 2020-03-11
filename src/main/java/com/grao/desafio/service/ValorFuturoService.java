package com.grao.desafio.service;

import com.grao.desafio.model.Investimento;


public interface ValorFuturoService {
	
	double calculo(Investimento investimento) throws Exception;	
	
}
