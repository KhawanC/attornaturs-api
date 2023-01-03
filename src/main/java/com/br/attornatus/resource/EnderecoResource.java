package com.br.attornatus.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.attornatus.DTO.EnderecoRequestDTO;
import com.br.attornatus.DTO.EnderecoResponseDTO;
import com.br.attornatus.DTO.EnderecoUpdateDTO;
import com.br.attornatus.services.EnderecoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/endereco")
@Tag(name = "Endereco", description = "Endpoint para o CRUD da entidade ENDERECO")
public class EnderecoResource {

	@Autowired
	EnderecoService service;

	@GetMapping
	@Operation(summary = "Listar todos os endereços")
	public ResponseEntity<List<EnderecoResponseDTO>> getAllEndereco() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("by-id")
	@Operation(summary = "Resgatar endereço com id especifico")
	public ResponseEntity<EnderecoResponseDTO> getEnderecoById(@RequestParam String idEndereco) {
		return new ResponseEntity<>(service.getByIdDTO(idEndereco), HttpStatus.OK);
	}

	@GetMapping("by-id-pessoa")
	@Operation(summary = "Listar todos os endereços de uma pessoa especifica")
	public ResponseEntity<List<EnderecoResponseDTO>> getEnderecoByIdPessoa(@RequestParam String idPessoa) {
		return new ResponseEntity<>(service.getByIdPessoa(idPessoa), HttpStatus.OK);
	}

	@GetMapping("principal-by-id-pessoa")
	@Operation(summary = "Resgatar endereço principal de uma pessoa especifica")
	public ResponseEntity<EnderecoResponseDTO> getEnderecoPrincipalByIdPessoa(@RequestParam String idPessoa) {
		return new ResponseEntity<>(service.getPrincipalByIdPessoa(idPessoa), HttpStatus.OK);
	}

	@PatchMapping
	@Operation(summary = "Alterar o endereço principal de uma pessoa especifica")
	public ResponseEntity<EnderecoResponseDTO> patchEnderecoPrincipal(@RequestParam(required = true) String idEndereco,
			@RequestParam(required = true) String idPessoa) {
		return new ResponseEntity<>(service.patchPrincipal(idEndereco, idPessoa), HttpStatus.OK);
	}

	@PostMapping
	@Operation(summary = "Salvar um novo endereço para uma pessoa especifica")
	public ResponseEntity<EnderecoResponseDTO> saveEndereco(@RequestParam String idPessoa,
			@RequestBody EnderecoRequestDTO dto) {
		return new ResponseEntity<>(service.save(idPessoa, dto), HttpStatus.CREATED);
	}

	@PutMapping
	@Operation(summary = "Atualizar um endereco especifico")
	public ResponseEntity<EnderecoResponseDTO> updateEndereco(@RequestParam String idEndereco,
			@RequestBody EnderecoUpdateDTO dto) {
		return new ResponseEntity<>(service.update(idEndereco, dto), HttpStatus.CREATED);
	}

	@DeleteMapping()
	@Operation(summary = "Deletar um endereço especifico")
	public ResponseEntity<EnderecoResponseDTO> deleteEndereco(@RequestParam String idEndereco) {
		return new ResponseEntity<>(service.delete(idEndereco), HttpStatus.OK);
	}

}
