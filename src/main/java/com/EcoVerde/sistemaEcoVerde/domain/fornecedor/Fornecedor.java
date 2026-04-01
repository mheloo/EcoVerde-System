package com.EcoVerde.sistemaEcoVerde.domain.fornecedor;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String documento; // CPF ou CNPJ
    private String pix;

}
