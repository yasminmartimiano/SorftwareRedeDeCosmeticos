package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "entrada_estoque")
public class EntradaEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "estoque_id", nullable = false)
    private Estoque estoque;

    @NotNull
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "data_entrada")
    private LocalDateTime dataEntrada;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private CategoriaProdutos categoria;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;

    public EntradaEstoque() {
    }

    public EntradaEstoque(Long id, Produto produto, Estoque estoque, Integer quantidade, LocalDateTime dataEntrada, CategoriaProdutos categoria, Fornecedor fornecedor) {
        this.id = id;
        this.produto = produto;
        this.estoque = estoque;
        this.quantidade = quantidade;
        this.dataEntrada = dataEntrada;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
    }


}










