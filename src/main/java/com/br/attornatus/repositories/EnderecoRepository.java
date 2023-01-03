package com.br.attornatus.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.attornatus.models.Endereco;
import com.br.attornatus.models.Pessoa;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
	List<Endereco> findByPessoa(Pessoa pessoa);
	
	Optional<Endereco> findByPrincipalTrueAndPessoa(Pessoa pessoa);
	Optional<Endereco> findByIdAndPessoa(UUID id, Pessoa pessoa);
}
