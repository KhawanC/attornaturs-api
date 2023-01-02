package com.br.attornatus.DTO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PessoaResponseDTO {

	private UUID id;

	private String nome;

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

}
