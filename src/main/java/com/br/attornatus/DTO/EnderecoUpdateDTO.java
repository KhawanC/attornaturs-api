package com.br.attornatus.DTO;

public class EnderecoUpdateDTO {

	private String apelido;

	private String logradouro;

	private String cep;

	private Integer numero;

	private String cidade;

	public EnderecoUpdateDTO() {
	}

	public EnderecoUpdateDTO(String apelido, String logradouro, String cep, Integer numero, String cidade) {
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
