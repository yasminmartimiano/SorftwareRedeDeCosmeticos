package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "servico")
public class Servicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_servico", nullable = false)
    private String nomeServico;

    @Column(name = "preco_servico", nullable = false)
    private Double precoServico;

    @Column(name = "duracao_estimada", nullable = true)
    private String duracaoEstimada;

    public Servicos(Long id, String nomeServico, Double precoServico, String duracaoEstimada) {
        this.id = id;
        this.nomeServico = nomeServico;
        this.precoServico = precoServico;
        this.duracaoEstimada = duracaoEstimada;
    }

    public Servicos() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public Double getPrecoServico() {
        return precoServico;
    }

    public void setPrecoServico(Double precoServico) {
        this.precoServico = precoServico;
    }

    public String getDuracaoEstimada() {
        return duracaoEstimada;
    }

    public void setDuracaoEstimada(String duracaoEstimada) {
        this.duracaoEstimada = duracaoEstimada;
    }
}

