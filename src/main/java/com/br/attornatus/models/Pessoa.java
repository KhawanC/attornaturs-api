package com.br.attornatus.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_nascimento", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Endereco> enderecos;

	public Pessoa() {
	}

	public Pessoa(String nome, Date dataNascimento, List<Endereco> enderecos) {
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

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}
