package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;

@Entity
public class Servicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "")
    private String nome_servico;
    @Column(name = "")
    private double preco_servico;
    @Column(name = "")
    private String duracao_estimado;


}
