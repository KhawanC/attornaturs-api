package com.br.attornatus.DTO;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;

public class EnderecoResponseDTO {

	@Schema(type = "UUID", example = "c60ee91a-24de-4d58-87ee-1ff0c44c3ca5", description = "Id do endereço")
	private UUID id;

	@Schema(type = "string", example = "Minha casa", description = "Apelido para o endereço")
	private String apelido;

	@Schema(type = "string", example = "Rua josé")
	private String logradouro;

	@Schema(type = "string", example = "00000-000")
	private String cep;

	@Schema(type = "integer", example = "1")
	private Integer numero;

	@Schema(type = "string", example = "Rio de Janeiro")
	private String cidade;

	@Schema(type = "boolena", example = "true", description = "Booleano para indicar se o endereço é o principal do usuário")
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
