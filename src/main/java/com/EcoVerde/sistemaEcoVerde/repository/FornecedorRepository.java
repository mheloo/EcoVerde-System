package com.EcoVerde.sistemaEcoVerde.repository;

import com.EcoVerde.sistemaEcoVerde.domain.fornecedor.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository <Fornecedor, Long> {
}

