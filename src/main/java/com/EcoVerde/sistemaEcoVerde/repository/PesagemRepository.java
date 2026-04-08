package com.EcoVerde.sistemaEcoVerde.repository;

import com.EcoVerde.sistemaEcoVerde.domain.fornecedor.Pesagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository

public interface PesagemRepository extends JpaRepository <Pesagem, Long> {

    //Busca todas as pesagens entre duas datas/horas
    List<Pesagem> findByDataRegistroBetween(LocalDateTime inicio, LocalDateTime fim);

}
