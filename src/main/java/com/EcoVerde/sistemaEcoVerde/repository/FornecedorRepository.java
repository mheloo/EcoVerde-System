package com.EcoVerde.sistemaEcoVerde.repository;

import com.EcoVerde.sistemaEcoVerde.domain.fornecedor.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FornecedorRepository extends JpaRepository <Fornecedor, Long> {
    Optional<Fornecedor> findByDocumento(String documento);
    Optional<Fornecedor> findByNome(String nome);
}

