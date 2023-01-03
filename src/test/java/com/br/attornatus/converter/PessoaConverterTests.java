package com.br.attornatus.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.attornatus.DTO.PessoaRequestDTO;
import com.br.attornatus.DTO.PessoaResponseDTO;
import com.br.attornatus.converters.PessoaConverter;
import com.br.attornatus.models.Endereco;
import com.br.attornatus.models.Pessoa;

@SpringBootTest
public class PessoaConverterTests {

	@Autowired
	PessoaConverter converter;
	
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void modelToResponseDTO() throws ParseException {
		List<Endereco> listaEndereco = new ArrayList<>();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse("22/06/2004");
		Pessoa model = new Pessoa("Kauã Carvalho", date, listaEndereco);
		PessoaResponseDTO dto = converter.modelToResponseDTO(model);
		assertEquals(model.getNome(), dto.getNome());
		assertEquals(model.getDataNascimento(), dto.getDataNascimento());
		assertEquals(model.getEnderecos(), dto.getEnderecos());
	}
	
	@Test
	void requestDTOToModel() throws ParseException {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse("22/07/2004");
		PessoaRequestDTO dto = new PessoaRequestDTO("Kauã de Souza", date);
		Pessoa model = converter.requestDTOToModel(dto);
		assertEquals(dto.getNome(), model.getNome());
		assertEquals(dto.getDataNascimento(), model.getDataNascimento());
	}
}
