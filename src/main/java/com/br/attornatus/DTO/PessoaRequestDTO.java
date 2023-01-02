package com.br.attornatus.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;

public class PessoaRequestDTO {

	@Schema(type = "string", example = "Ciclano da Silva Sauro", description = "Nome da pessoa")
	private String nome;

	@Schema(type = "string", pattern = "dd/MM/yyyy", example = "01/01/2023", description = "Data de aniversário da pessoa, padrão dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	public PessoaRequestDTO() {
	}

	public PessoaRequestDTO(String nome, Date dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
