package com.br.attornatus.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.attornatus.DTO.EnderecoRequestDTO;
import com.br.attornatus.DTO.EnderecoResponseDTO;
import com.br.attornatus.converters.EnderecoConverter;
import com.br.attornatus.models.Endereco;
import com.br.attornatus.models.Pessoa;
import com.br.attornatus.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository repository;

	@Autowired
	EnderecoConverter converter;

	@Autowired
	PessoaService pessoaService;

	public List<EnderecoResponseDTO> getAll() {
		List<Endereco> listModel = repository.findAll();
		List<EnderecoResponseDTO> listDTO = new ArrayList<>();
		listModel.forEach(endereco -> {
			listDTO.add(converter.modelToResponseDTO(endereco));
		});
		return listDTO;
	}
	
//	public EnderecoResponseDTO getById(String id) {
//		
//	}
//	
//	public List<EnderecoResponseDTO> getByIdPessoa(String idPessoa) {
//		
//	}

	public EnderecoResponseDTO save(String idPessoa, EnderecoRequestDTO dto) {
		Pessoa pessoa = pessoaService.getById(idPessoa);
		Endereco model = converter.requestDTOToModel(dto, pessoa);
		return converter.modelToResponseDTO(repository.save(model));

	}
}
