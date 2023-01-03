package com.br.attornatus.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.attornatus.DTO.PessoaRequestDTO;
import com.br.attornatus.DTO.PessoaResponseDTO;
import com.br.attornatus.DTO.PessoaUpdateDTO;
import com.br.attornatus.exceptions.NotFoundException;
import com.br.attornatus.repositories.PessoaRepository;

@SpringBootTest
public class PessoaServiceTests {

	@Autowired
	PessoaService service;
	
	@Autowired
	PessoaRepository repository;

	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void savePessoa() throws ParseException {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse("22/01/2004");
		PessoaRequestDTO pessoa = new PessoaRequestDTO("Kauã Cassiano", date);
		assertNotNull(service.save(pessoa));
	}

	@Test
	void getById() throws ParseException {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse("22/02/2004");
		PessoaRequestDTO pessoa = new PessoaRequestDTO("Kauã Egypto", date);
		PessoaResponseDTO newPessoa = service.save(pessoa);
		assertEquals(service.getById(newPessoa.getId().toString()).getId(), newPessoa.getId());
	}

	@Test
	void getByNome() throws ParseException {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse("22/03/2004");
		PessoaRequestDTO pessoa = new PessoaRequestDTO("Kauã Gomes", date);
		PessoaResponseDTO newPessoa = service.save(pessoa);
		assertEquals(service.getByNome("Kauã Gomes").getId(), newPessoa.getId());
	}

	@Test
	void updatePessoa() throws ParseException {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse("22/04/2004");
		PessoaRequestDTO pessoa = new PessoaRequestDTO("Kauã Silva", date);
		PessoaResponseDTO newPessoa = service.save(pessoa);
		PessoaUpdateDTO updatePessoa = new PessoaUpdateDTO("Kauã Manoel Gomes", date);
		service.update(newPessoa.getId().toString(), updatePessoa);
		assertEquals(service.getByNome("Kauã Manoel Gomes").getId(), newPessoa.getId());
	}

	@Test
	void deletePessoa() throws ParseException {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse("22/05/2004");
		PessoaRequestDTO pessoa = new PessoaRequestDTO("Kauã Mercury", date);
		PessoaResponseDTO newPessoa = service.save(pessoa);
		System.out.println(newPessoa);
		repository.deleteById(newPessoa.getId());
		assertThrows(NotFoundException.class, () -> {
			service.getByNome("Kauã Cardoso");
		});
	}
}
