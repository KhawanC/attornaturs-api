package com.br.attornatus.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.attornatus.DTO.EnderecoRequestDTO;
import com.br.attornatus.DTO.EnderecoResponseDTO;
import com.br.attornatus.models.Endereco;
import com.br.attornatus.models.Pessoa;

@Component
public class EnderecoConverter {

	@Autowired
	ModelMapper mapper;
	
	public EnderecoResponseDTO modelToResponseDTO(Endereco model) {
		return mapper.map(model, EnderecoResponseDTO.class);
	}
	
	public Endereco requestDTOToModel(EnderecoRequestDTO dto, Pessoa pessoa) {
		Endereco model = mapper.map(dto, Endereco.class);
		model.setPessoa(pessoa);
		model.setPrincipal(false);
		
		return model;
	}
}
