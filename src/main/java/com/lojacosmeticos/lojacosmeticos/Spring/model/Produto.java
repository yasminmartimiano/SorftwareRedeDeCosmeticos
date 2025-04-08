package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nomeProduto;
    private String descriacao;
    private CategoriaProdutos categoriaProdutos;
    private double preco_produto;


    public Produto() {
    }


    public Produto(String nomeProduto, String descriacao, CategoriaProdutos categoriaProdutos, double preco_produto) {
        this.nomeProduto = nomeProduto;
        this.descriacao = descriacao;
        this.categoriaProdutos = categoriaProdutos;
        this.preco_produto = preco_produto;
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

    public double getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(double preco_produto) {
        this.preco_produto = preco_produto;
    }

}
