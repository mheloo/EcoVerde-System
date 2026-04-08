package com.EcoVerde.sistemaEcoVerde.controller;

import com.EcoVerde.sistemaEcoVerde.domain.fornecedor.Pesagem;
import com.EcoVerde.sistemaEcoVerde.dto.NotaPesagemDTO;
import com.EcoVerde.sistemaEcoVerde.service.PesagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/pesagens")
public class PesagemController {

    @Autowired
    private PesagemService service;

    // Rota: POST http://localhost:8080/api/pesagens/registrar
    @PostMapping("/registrar")
    public ResponseEntity<NotaPesagemDTO> registrar(@RequestBody PesagemRequest request) {

        NotaPesagemDTO nota = service.registrarESalvar(
                request.getDocumento(),
                request.getPeso(),
                request.getValorKg()
        );

        return ResponseEntity.ok(nota);
    }

    @GetMapping("/relatorio-hoje")
    public ResponseEntity<List<Pesagem>> getRelatorioHoje() {
        List<Pesagem> lista = service.listarPesagemDoDia();

        return ResponseEntity.ok(lista);
    }
}
