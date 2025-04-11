package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "")
    private String nomeProduto;
    @Column(name = "")
    private String descriacao;
    @Column(name = "")
    private CategoriaProdutos categoriaProdutos;
    @Column(name = "")
    private int quantidadeEstoque;
    @Column(name = "")
    private double precoProduto;

    @OneToMany(mappedBy = "idProduto", cascade = CascadeType.ALL)
    List<EntradaEstoque> entradaEstoque;

    @OneToMany(mappedBy = "idProduto",cascade = CascadeType.ALL)
    List<SaidaEstoque> saidaEstoque;



    public Produto() {
    }


    public Produto(Long id, String nomeProduto, String descriacao, CategoriaProdutos categoriaProdutos, int quantidadeEstoque, double precoProduto, List<EntradaEstoque> entradaEstoque, List<SaidaEstoque> saidaEstoque) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.descriacao = descriacao;
        this.categoriaProdutos = categoriaProdutos;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoProduto = precoProduto;
        this.entradaEstoque = entradaEstoque;
        this.saidaEstoque = saidaEstoque;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescriacao() {
        return descriacao;
    }

    public void setDescriacao(String descriacao) {
        this.descriacao = descriacao;
    }

    public CategoriaProdutos getCategoriaProdutos() {
        return categoriaProdutos;
    }

    public void setCategoriaProdutos(CategoriaProdutos categoriaProdutos) {
        this.categoriaProdutos = categoriaProdutos;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public List<EntradaEstoque> getEntradaEstoque() {
        return entradaEstoque;
    }

    public void setEntradaEstoque(List<EntradaEstoque> entradaEstoque) {
        this.entradaEstoque = entradaEstoque;
    }

    public List<SaidaEstoque> getSaidaEstoque() {
        return saidaEstoque;
    }

    public void setSaidaEstoque(List<SaidaEstoque> saidaEstoque) {
        this.saidaEstoque = saidaEstoque;
    }
}
