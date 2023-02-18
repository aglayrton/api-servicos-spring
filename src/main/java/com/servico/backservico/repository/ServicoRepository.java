package com.servico.backservico.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.servico.backservico.entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{

    @Query("select s from Servico s where s.status = 'pendentes'")
    List<Servico> buscarSerivcosPagamentoPedente();

    @Query("select s from Servico s where s.status = 'cancelado' ")
    List<Servico> buscarSerivcosCancelados();

}
