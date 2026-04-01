package com.EcoVerde.sistemaEcoVerde.domain.fornecedor;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Pesagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double pesoKg;
    private Double valorPorQuilo;

    @ManyToOne
    private Fornecedor fornecedor;
    private LocalDataTime dataRegistro;

}
