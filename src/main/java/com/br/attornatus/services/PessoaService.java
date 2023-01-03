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

	public PessoaResponseDTO getByParam(String idPessoa, String nome) {
		if ((nome == null) && (idPessoa == null)) {
			throw new PessoaException("Ambos os parametros estão nulos!");
		} else {
			if ((idPessoa == null)) {
				return converter.modelToResponseDTO(this.getByNome(nome));
			} else if ((nome == null)) {
				return converter.modelToResponseDTO(this.getById(idPessoa));
			}
			Optional<Pessoa> modelById = repository.findById(UUID.fromString(idPessoa));
			Optional<Pessoa> modelByNome = repository.findByNome(nome);
			if (modelById.isEmpty() && modelByNome.isEmpty())
				throw new NotFoundException("Essa pessoa não existe");
			else if (modelById.isEmpty())
				return converter.modelToResponseDTO(modelByNome.get());
			else
				return converter.modelToResponseDTO(modelById.get());
		}
	}

	public Pessoa getById(String idPessoa) {
		Optional<Pessoa> model = repository.findById(UUID.fromString(idPessoa));
		if (model.isEmpty())
			throw new NotFoundException("Essa pessoa não existe");
		else
			return model.get();
	}

	public PessoaResponseDTO getByIdDTO(String idPessoa) {
		return converter.modelToResponseDTO(this.getById(idPessoa));
	}

	public Pessoa getByNome(String nome) {
		Optional<Pessoa> model = repository.findByNome(nome);
		if (model.isEmpty())
			throw new NotFoundException("Essa pessoa não existe");
		else
			return model.get();
	}

	public PessoaResponseDTO getByNomeDTO(String nome) {
		return converter.modelToResponseDTO(this.getByNome(nome));
	}

	public PessoaResponseDTO save(PessoaRequestDTO dto) {
		Pessoa model = repository.save(converter.requestDTOToModel(dto));
		return converter.modelToResponseDTO(model);
	}

	public PessoaResponseDTO update(String idPessoa, PessoaUpdateDTO dto) {
		Pessoa oldPessoa = this.getById(idPessoa);
		Pessoa newPessoa = converter.updateDTOToModel(dto, oldPessoa);
		return converter.modelToResponseDTO(repository.save(newPessoa));
	}

	public PessoaResponseDTO delete(String idPessoa) {
		Pessoa pessoa = this.getById(idPessoa);
		repository.delete(pessoa);
		return converter.modelToResponseDTO(pessoa);
	}
}
