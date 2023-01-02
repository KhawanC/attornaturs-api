package com.br.attornatus.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.attornatus.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

}
