package com.servico.backservico.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "servico")
@Data
public class Servico {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String nomeCliente;

  private LocalDate dataInicio = LocalDate.now();

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate dataTermino;

  private String description;

  private Double valorServico;

  private Double valorPago;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate dataPagamento;

  private String status;
}
