package com.br.attornatus.DTO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;

public class PessoaResponseDTO {

	@Schema(type = "UUID", example = "c60ee91a-24de-4d58-87ee-1ff0c44c3ca5", description = "Id da pessoa")
	private UUID id;

	@Schema(type = "string", example = "Ciclano da Silva Sauro", description = "Nome da pessoa")
	private String nome;

	@Schema(type = "string", pattern = "dd/MM/yyyy", example = "01/01/2023", description = "Data de aniversário da pessoa, padrão dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	private List<EnderecoResponseDTO> enderecos;

	public PessoaResponseDTO() {
	}

	public PessoaResponseDTO(UUID id, String nome, Date dataNascimento, List<EnderecoResponseDTO> enderecos) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.enderecos = enderecos;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public List<EnderecoResponseDTO> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoResponseDTO> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public String toString() {
		return "PessoaResponseDTO [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", enderecos="
				+ enderecos + "]";
	}

}
