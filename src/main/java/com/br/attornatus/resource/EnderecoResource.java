package com.br.attornatus.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.attornatus.DTO.EnderecoRequestDTO;
import com.br.attornatus.DTO.EnderecoResponseDTO;
import com.br.attornatus.services.EnderecoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/endereco")
@Tag(name = "Endereco", description = "Endpoint para o CRUD da entidade ENDERECO")
public class EnderecoResource {

	@Autowired
	EnderecoService service;

	@GetMapping
	public ResponseEntity<List<EnderecoResponseDTO>> getAllEndereco() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<EnderecoResponseDTO> saveEndereco(@RequestParam String idPessoa,
			@RequestBody EnderecoRequestDTO dto) {
		return new ResponseEntity<>(service.save(idPessoa, dto), HttpStatus.CREATED);
	}

}
