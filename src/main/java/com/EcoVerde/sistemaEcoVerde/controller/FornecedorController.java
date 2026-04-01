package com.EcoVerde.sistemaEcoVerde.controller;

import com.EcoVerde.sistemaEcoVerde.domain.fornecedor.Fornecedor;
import com.EcoVerde.sistemaEcoVerde.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
@RequiredArgsConstructor

public class FornecedorController {

    @Autowired
    private FornecedorRepository repository;

    @PostMapping
    public Fornecedor criar (@RequestBody Fornecedor fornecedor) {

        return repository.save(fornecedor);

    }

    @GetMapping
    public List<Fornecedor> listar() {

        return repository.findAll();

    }

    @PutMapping("/por-documento/{documento}")
    public ResponseEntity<Fornecedor> alterarInfo(@PathVariable String documento, @RequestBody Fornecedor fornecedorAtualizado) {

        return repository.findByDocumento(documento).map(fornecedor -> {
            fornecedor.setNome(fornecedorAtualizado.getNome());
            fornecedor.setPix(fornecedorAtualizado.getPix());

            Fornecedor salvo = repository.save(fornecedor);
            return ResponseEntity.ok(salvo);
        })
                .orElse(ResponseEntity.notFound().build());
    }
}
