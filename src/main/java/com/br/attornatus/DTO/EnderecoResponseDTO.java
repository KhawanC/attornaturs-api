package com.br.attornatus.DTO;

import java.util.UUID;

public class EnderecoResponseDTO {

	private UUID id;

	private String apelido;

	private String logradouro;

	private String cep;

	private Integer numero;

	private String cidade;

	private Boolean principal;

	public EnderecoResponseDTO() {
	}

	public EnderecoResponseDTO(UUID id, String apelido, String logradouro, String cep, Integer numero, String cidade,
			Boolean principal) {
		this.id = id;
		this.apelido = apelido;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.principal = principal;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

}
