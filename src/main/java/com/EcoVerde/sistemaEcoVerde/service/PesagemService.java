package com.EcoVerde.sistemaEcoVerde.service;

import com.EcoVerde.sistemaEcoVerde.domain.fornecedor.Fornecedor;
import com.EcoVerde.sistemaEcoVerde.domain.fornecedor.Pesagem;
import com.EcoVerde.sistemaEcoVerde.dto.NotaPesagemDTO;
import com.EcoVerde.sistemaEcoVerde.repository.FornecedorRepository;
import com.EcoVerde.sistemaEcoVerde.repository.PesagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PesagemService {

    @Autowired
    private PesagemRepository pesagemRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public NotaPesagemDTO registrarESalvar(String documento, Double peso, Double valorKg){

        // Busca Fornecedor
        Fornecedor fornecedor = fornecedorRepository.findByDocumento(documento)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado!"));

        // Realiza o cálculo
        double total = peso * valorKg;

        //Cria a Pesagem no Banco de Dados
        Pesagem pesagem = new Pesagem();
        pesagem.setFornecedor(fornecedor);
        pesagem.setPesoKg(peso);
        pesagem.setValorPorQuilo(valorKg);
        pesagem.setDataRegistro(LocalDateTime.now());
        Pesagem pesagemSalva = pesagemRepository.save(pesagem);

        // Retorna a Nota pronta
        return new NotaPesagemDTO(
                fornecedor.getNome(),
                fornecedor.getDocumento(),
                fornecedor.getPix(),
                pesagemSalva.getPesoKg(),
                pesagemSalva.getValorPorQuilo(),
                total,
                pesagemSalva.getDataRegistro()
        );

    }

}
