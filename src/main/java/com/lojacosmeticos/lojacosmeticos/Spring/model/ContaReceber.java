package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "conta_receber")
public class ContaReceber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "valor" , nullable = false)
    private Double valor;
    @NotNull
    @Column(name = "data_pagamento", nullable = false)
    private LocalDate dataPagamento;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "status_recebimento", nullable = false)
    private StatusPagamento statusPagamento;
    @OneToOne
    @NotNull
    @JoinColumn(name = "pagamento_id", nullable = false)
    private Pagamento pagamentoId;
    @OneToOne
    @NotNull
    @JoinColumn(name = "venda_id", nullable = false)
    private Vendas vendas;

    public ContaReceber(Long id, Double valor, LocalDate dataPagamento, StatusPagamento statusPagamento, Pagamento pagamentoId, Vendas vendas) {
        this.id = id;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.statusPagamento = statusPagamento;
        this.pagamentoId = pagamentoId;
        this.vendas = vendas;
    }


}
