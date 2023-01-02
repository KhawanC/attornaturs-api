package com.br.attornatus.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.attornatus.DTO.PessoaRequestDTO;
import com.br.attornatus.DTO.PessoaResponseDTO;
import com.br.attornatus.DTO.PessoaUpdateDTO;
import com.br.attornatus.converters.PessoaConverter;
import com.br.attornatus.exceptions.NotFoundException;
import com.br.attornatus.exceptions.PessoaException;
import com.br.attornatus.models.Pessoa;
import com.br.attornatus.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository repository;

	@Autowired
	PessoaConverter converter;

	public List<PessoaResponseDTO> getAll() {

		List<Pessoa> listModel = repository.findAll();
		List<PessoaResponseDTO> listDTO = new ArrayList<>();
		listModel.forEach(pessoa -> {
			System.out.println(pessoa);
			listDTO.add(converter.modelToResponseDTO(pessoa));
		});

		return listDTO;
	}

	public PessoaResponseDTO getByParam(String id, String nome) {
		if ((nome == null) && (id == null)) {
			throw new PessoaException("Ambos os parametros estão nulos!");
		} else {
			if ((id == null)) {
				return converter.modelToResponseDTO(this.getByNome(nome));
			} else if ((nome == null)) {
				return converter.modelToResponseDTO(this.getById(id));
			}
			Optional<Pessoa> modelById = repository.findById(UUID.fromString(id));
			Optional<Pessoa> modelByNome = repository.findByNome(nome);
			if (modelById.isEmpty() && modelByNome.isEmpty())
				throw new NotFoundException("Essa pessoa não existe");
			else if (modelById.isEmpty())
				return converter.modelToResponseDTO(modelByNome.get());
			else
				return converter.modelToResponseDTO(modelById.get());
		}
	}

	public Pessoa getById(String id) {
		Optional<Pessoa> model = repository.findById(UUID.fromString(id));
		if (model.isEmpty())
			throw new NotFoundException("Essa pessoa não existe");
		else
			return model.get();
	}

	public Pessoa getByNome(String nome) {
		Optional<Pessoa> model = repository.findByNome(nome);
		if (model.isEmpty())
			throw new NotFoundException("Essa pessoa não existe");
		else
			return model.get();
	}

	public PessoaResponseDTO save(PessoaRequestDTO dto) {
		Pessoa model = repository.save(converter.requestDTOToModel(dto));
		return converter.modelToResponseDTO(model);
	}

	public PessoaResponseDTO update(String id, PessoaUpdateDTO dto) {
		Optional<Pessoa> model = repository.findById(UUID.fromString(id));
		if (model.isEmpty())
			throw new NotFoundException("Essa pessoa não existe");
		Pessoa newPessoa = converter.updateDTOToModel(dto, model.get());
		return converter.modelToResponseDTO(repository.save(newPessoa));
	}

	public PessoaResponseDTO delete(String id) {
		Pessoa pessoa = this.getById(id);
		repository.deleteById(UUID.fromString(id));
		return converter.modelToResponseDTO(pessoa);
	}
}
