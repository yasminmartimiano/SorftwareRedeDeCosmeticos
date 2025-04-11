package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "")
    private String cnpj;
    @Column(name = "")
    private String razaoSocial;
    @Column(name = "")
    private String nomeFantasia;
    @Column(name = "")
    private String endereco;
    @Column(name = "")
    private String email;
    @Column(name = "")
    private String telefone;

    @OneToMany(mappedBy = "idFornecedor", cascade = CascadeType.ALL)
    List<EntradaEstoque> estoque;

    public Fornecedor() {
    }

    public Fornecedor(Long id, String cnpj, String razaoSocial, String nomeFantasia, String endereco, String email, String telefone) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
