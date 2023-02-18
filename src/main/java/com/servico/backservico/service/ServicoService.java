package com.servico.backservico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servico.backservico.entity.Servico;
import com.servico.backservico.repository.ServicoRepository;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository repository;

    public List<Servico> buscarTodos() {
        return repository.findAll();
    }

    public List<Servico> buscarServicosPagamentosPedentesList() {
        return repository.buscarSerivcosPagamentoPedente();
    }

    public List<Servico> buscarServicosCanceladosList() {
        return repository.buscarSerivcosCancelados();
    }

    public Servico inserir(Servico servico) {
        if (servico.getValorPago() == null || servico.getValorPago() == 0 || servico.getDataPagamento() == null) {
            servico.setStatus("pendente");
        } else {
            servico.setStatus("realizado");
        }
        Servico objt = repository.saveAndFlush(servico);
        return objt;
    }

    public Servico atualizar(Servico servico) {
        if (servico.getValorPago() != null && servico.getValorPago() > 0 && servico.getDataPagamento() != null) {
            servico.setStatus("realizado");
        }else{
            servico.setStatus("cancelado");
        }
        return repository.saveAndFlush(servico);
    }

    public void remover(long id){
        repository.deleteById(id);
    }
}