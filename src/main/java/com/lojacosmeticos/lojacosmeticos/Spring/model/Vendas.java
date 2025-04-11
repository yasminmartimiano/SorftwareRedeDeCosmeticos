package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Vendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "")
    private Date data_venda;
    @ManyToOne
    @JoinColumn(name = "")
    private Long id_cliente;
    @ManyToOne
    @JoinColumn(name = "")
    private Long id_funcionario;
    @Column(name = "")
    private double total;
}
