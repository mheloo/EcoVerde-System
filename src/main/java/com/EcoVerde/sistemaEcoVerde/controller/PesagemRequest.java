package com.EcoVerde.sistemaEcoVerde.controller;

import lombok.Data;

@Data

public class PesagemRequest {
    private String documento;
    private Double peso;
    private Double valorKg;
}
