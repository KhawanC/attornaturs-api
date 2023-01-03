package com.br.attornatus.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.attornatus.DTO.EnderecoRequestDTO;
import com.br.attornatus.DTO.EnderecoResponseDTO;
import com.br.attornatus.DTO.EnderecoUpdateDTO;
import com.br.attornatus.converters.EnderecoConverter;
import com.br.attornatus.exceptions.EnderecoException;
import com.br.attornatus.exceptions.NotFoundException;
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

	public Endereco getById(String idEndereco) {
		Optional<Endereco> model = repository.findById(UUID.fromString(idEndereco));
		if (model.isEmpty())
			throw new NotFoundException("Esse endereco não existe");
		return model.get();
	}

	public EnderecoResponseDTO getByIdDTO(String idEndereco) {
		return converter.modelToResponseDTO(this.getById(idEndereco));
	}

	public List<EnderecoResponseDTO> getByIdPessoa(String idPessoa) {
		Pessoa pessoa = pessoaService.getById(idPessoa);
		List<EnderecoResponseDTO> listDTO = new ArrayList<>();
		repository.findByPessoa(pessoa).forEach(endereco -> {
			listDTO.add(converter.modelToResponseDTO(endereco));
		});
		;
		return listDTO;
	}

	public EnderecoResponseDTO getPrincipalByIdPessoa(String idPessoa) {
		Pessoa pessoa = pessoaService.getById(idPessoa);
		Optional<Endereco> endereco = repository.findByPrincipalTrueAndPessoa(pessoa);
		if (endereco.isEmpty())
			throw new EnderecoException("Pessoa não possui endereço principal ativo");
		else
			return converter.modelToResponseDTO(endereco.get());
	}

	public EnderecoResponseDTO save(String idPessoa, EnderecoRequestDTO dto) {
		Pessoa pessoa = pessoaService.getById(idPessoa);
		Endereco model = converter.requestDTOToModel(dto, pessoa);
		return converter.modelToResponseDTO(repository.save(model));

	}
	
	public EnderecoResponseDTO update(String idEndereco, EnderecoUpdateDTO dto) {
		Endereco oldEndereco = this.getById(idEndereco);
		Endereco newEndereco = converter.updateDTOToModel(dto, oldEndereco);
		return converter.modelToResponseDTO(repository.save(newEndereco));
	}

	public EnderecoResponseDTO patchPrincipal(String idEndereco, String idPessoa) {
		Endereco endereco = this.getById(idEndereco);
		if (endereco.getPrincipal())
			throw new EnderecoException("Esse endereco já é o principal");
		else {
			Pessoa pessoa = pessoaService.getById(idPessoa);
			if (repository.findByIdAndPessoa(UUID.fromString(idEndereco), pessoa).isEmpty())
				throw new NotFoundException("Não existe este endereço para a pessoa pesquisada");
			Optional<Endereco> oldPrincipal = repository.findByPrincipalTrueAndPessoa(pessoa);
			endereco.setPrincipal(true);
			if (!oldPrincipal.isEmpty()) {
				Endereco oldEndereco = oldPrincipal.get();
				oldEndereco.setPrincipal(false);
				repository.save(oldEndereco);
			}

			return converter.modelToResponseDTO(repository.save(endereco));
		}
	}
	
	public EnderecoResponseDTO delete(String id) {
		Endereco endereco = this.getById(id);
		repository.delete(endereco);
		return converter.modelToResponseDTO(endereco);
	}
}
