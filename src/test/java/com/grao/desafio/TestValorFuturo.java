package com.grao.desafio;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grao.desafio.model.Investimento;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestValorFuturo {
	

	@Autowired
	private MockMvc mockMvc;
	
	private String objectoToJson(Object object) throws Exception{
		return new ObjectMapper().writeValueAsString(object);
	}
	
	@Test
	public void valorFuturoOk() throws Exception{
		
		Investimento request = new Investimento();
		request.setValorPresente(100);
		request.setSemanas(36);
		
		Double response = 103.02;
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/valorfuturo/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectoToJson(request)))
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.content().json(objectoToJson(response)));
				
	}
	
	@Test
	public void valorFuturoValoresNegativos() throws Exception{
		
		Investimento request = new Investimento();
		request.setValorPresente(-1);
		request.setSemanas(-1);
		
		List<String> response = new ArrayList<String>();
		response.add("A quantidade de semanas deve ser maior que zero");
		response.add("O valor presente deve ser maior que zero");
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/valorfuturo/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectoToJson(request)))
			.andExpect(status().isBadRequest())
			.andExpect(MockMvcResultMatchers.content().json(objectoToJson(response)));
				
	}
	
	@Test
	public void valorFuturoValoresZerados() throws Exception{
		
		Investimento request = new Investimento();
		request.setValorPresente(0);
		request.setSemanas(0);
		
		List<String> response = new ArrayList<String>();
		response.add("A quantidade de semanas deve ser maior que zero");
		response.add("O valor presente deve ser maior que zero");
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/valorfuturo/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectoToJson(request)))
			.andExpect(status().isBadRequest())
			.andExpect(MockMvcResultMatchers.content().json(objectoToJson(response)));
				
	}


}