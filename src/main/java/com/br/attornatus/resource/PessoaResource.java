package com.br.attornatus.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.attornatus.DTO.PessoaRequestDTO;
import com.br.attornatus.DTO.PessoaResponseDTO;
import com.br.attornatus.DTO.PessoaUpdateDTO;
import com.br.attornatus.services.PessoaService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/pessoa")
@Tag(name = "Pessoa", description = "Endpoint para o CRUD da entidade PESSOA")
public class PessoaResource {

	@Autowired
	PessoaService service;

	@GetMapping
	public ResponseEntity<List<PessoaResponseDTO>> getAllPessoas() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("by-param")
	public ResponseEntity<PessoaResponseDTO> getPessoaByParam(@RequestParam(required = false) String id,
			@RequestParam(required = false) String nome) {
		return new ResponseEntity<>(service.getByParam(id, nome), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<PessoaResponseDTO> savePessoa(@RequestBody PessoaRequestDTO dto) {
		return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<PessoaResponseDTO> updatePessoa(@RequestBody PessoaUpdateDTO dto, @RequestParam(required = true) String id) {
		return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
	}
}
