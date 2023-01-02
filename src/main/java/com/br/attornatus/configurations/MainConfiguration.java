package com.br.attornatus.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
