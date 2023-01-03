package com.br.attornatus.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID id;

	@Column(name = "apelido", nullable = false)
	private String apelido;

	@ManyToOne(fetch = FetchType.LAZY)
	private Pessoa pessoa;

	@Column(name = "logradouro", nullable = false)
	private String logradouro;

	@Column(name = "cep", nullable = false)
	private String cep;

	@Column(name = "numero")
	private Integer numero;

	@Column(name = "cidade", nullable = false)
	private String cidade;

	@Column(name = "principal", nullable = false)
	private Boolean principal;

	public Endereco() {
	}

	public Endereco(String apelido, Pessoa pessoa, String logradouro, String cep, Integer numero,
			String cidade, Boolean principal) {
		this.apelido = apelido;
		this.pessoa = pessoa;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
