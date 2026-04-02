package com.EcoVerde.sistemaEcoVerde.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor

public class NotaPesagemDTO {

    private String nomeFornecedor;
    private String documento;
    private String pix;
    private Double pesoTotal;
    private Double valorPorQuilo;
    private Double valorTotalAReceber;
    private LocalDateTime data;

}
