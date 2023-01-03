package com.br.attornatus.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class EnderecoRequestDTO {

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

	public EnderecoRequestDTO() {
	}

	public EnderecoRequestDTO(String apelido, String logradouro, String cep, Integer numero, String cidade) {
		this.apelido = apelido;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
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

}
