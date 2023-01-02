package com.br.attornatus.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.attornatus.DTO.PessoaRequestDTO;
import com.br.attornatus.DTO.PessoaResponseDTO;
import com.br.attornatus.DTO.PessoaUpdateDTO;
import com.br.attornatus.models.Endereco;
import com.br.attornatus.models.Pessoa;

@Component
public class PessoaConverter {
	
	@Autowired
	ModelMapper mapper;

	public PessoaResponseDTO modelToResponseDTO(Pessoa model) {
		return mapper.map(model, PessoaResponseDTO.class);
	}
	
	public Pessoa requestDTOToModel(PessoaRequestDTO dto) {
		List<Endereco> listaEndereco = new ArrayList<>();
		Pessoa model = mapper.map(dto, Pessoa.class);
		model.setEnderecos(listaEndereco);
		return model;
	}
	
	public Pessoa updateDTOToModel(PessoaUpdateDTO dto, Pessoa oldPessoa) {
		Pessoa model = mapper.map(dto, Pessoa.class);
		model.setId(oldPessoa.getId());
		model.setEnderecos(oldPessoa.getEnderecos());
		return model;
	}
}
