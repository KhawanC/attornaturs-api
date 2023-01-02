package com.br.attornatus.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.attornatus.models.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
	Optional<Pessoa> findByNome(String nome);
}
