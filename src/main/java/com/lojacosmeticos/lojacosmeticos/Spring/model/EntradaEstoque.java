package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;

@Entity
public class EntradaEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "")
    private int idProduto;
    @Column(name = "")
    private int quantidade;
    @Column(name = "")
    private SimpleDateFormat dataEntrada;
    @ManyToOne
    @JoinColumn(name = "")
    private int idFornecedor;







}
