package com.grao.desafio.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grao.desafio.model.Investimento;
import com.grao.desafio.service.ValorFuturoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/valorfuturo")
public class ValorFuturoController {
	
	@Autowired
	private ValorFuturoService valorFuturoService;
	
	@ApiOperation(value="Calcula o valor futuro do capital em semanas aplicado à 100% da taxa selic")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Retorna o valor futuro calculado"),
			@ApiResponse(code = 400, message = "Dados da requisição inválidos")
	})
	@GetMapping(value="/", produces ="application/json", consumes="application/json")
	public double valorFuturo(@Valid @RequestBody Investimento investimento) throws Exception {
		return valorFuturoService.calculo(investimento);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> handlException(MethodArgumentNotValidException exception) {
		
		List<String> errorList = exception.getBindingResult().getAllErrors().stream()
				.map(ObjectError::getDefaultMessage)
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<String>>(errorList, HttpStatus.BAD_REQUEST);
	}

}
