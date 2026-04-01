package com.EcoVerde.sistemaEcoVerde.repository;

import com.EcoVerde.sistemaEcoVerde.domain.fornecedor.Pesagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PesagemRepository extends JpaRepository <Pesagem, Long> {
    
}
