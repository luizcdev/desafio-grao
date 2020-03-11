package com.grao.desafio.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()                                   
                .apis(RequestHandlerSelectors.basePackage("com.grao.desafio.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessageForGET())
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Desafio Grão",
                "API para cálculo de rendimentos",
                "1.0",
                "",
                new Contact("Luiz Oliveira", "",
                        "luizcdev@gmail.com"),
                "",
                "", Collections.emptyList());

        return apiInfo;
    }
	
    private List<ResponseMessage> responseMessageForGET()
    {
    	return Arrays.asList(
    	        new ResponseMessageBuilder().code(200).build(),
    	        new ResponseMessageBuilder().code(400).build());
    }

}
