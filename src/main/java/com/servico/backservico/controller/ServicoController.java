package com.servico.backservico.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servico.backservico.entity.Servico;
import com.servico.backservico.service.ServicoService;

import jakarta.websocket.server.PathParam;

/**
 * ServicoController
 */
@RestController
@RequestMapping("/api/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Servico>> buscarTodos() {
        List<Servico> servico = servicoService.buscarTodos();
        return ResponseEntity.ok().body(servico);
    }

    @GetMapping("/pendentes")
    public ResponseEntity<List<Servico>> buscarPagamentosPendentes() {
        List<Servico> servico = servicoService.buscarServicosPagamentosPedentesList();
        return ResponseEntity.ok().body(servico);
    }

    @GetMapping("/cancelados")
    public ResponseEntity<List<Servico>> buscarPagamentosCancelados() {
        List<Servico> servico = servicoService.buscarServicosCanceladosList();
        return ResponseEntity.ok().body(servico);
    }

    @PostMapping
    public ResponseEntity<Servico> inserir(@RequestBody Servico servico){
        Servico obj = servicoService.inserir(servico);
        return ResponseEntity.ok(obj);
    }

    @PutMapping()
    public ResponseEntity<Servico> atualizar(@RequestBody Servico servico){
        Servico obj = servicoService.atualizar(servico);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Long id){
        servicoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
