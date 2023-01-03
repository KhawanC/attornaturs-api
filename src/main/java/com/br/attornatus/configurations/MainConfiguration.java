package com.br.attornatus.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class MainConfiguration {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Attornaturs Processo Seletivo API")
						.version("v1")
						.description("API para o processo seletivo da Attornatus")
						.termsOfService("https://www.attornatus.com.br")
				);
	}
}
