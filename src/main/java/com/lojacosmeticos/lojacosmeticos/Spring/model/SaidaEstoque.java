package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;

@Entity
public class SaidaEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "")
    private int idProduto;
    @Column(name = "")
    private int quantidade;
    @Column(name = "")
    private SimpleDateFormat dataSaida;
    @Column(name = "")
    private CategoriaProdutos categoria;
    @ManyToOne
    @JoinColumn(name = "")
    private int id_funcionario;

}
