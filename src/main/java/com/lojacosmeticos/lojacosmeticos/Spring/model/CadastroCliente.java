package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class CadastroCliente  extends  Cadastro{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "idCliente",cascade = CascadeType.ALL)
    private List<Agendamentos> agendamentos;

    @OneToMany(mappedBy = "idCliente", cascade = CascadeType.ALL)
    List<Vendas> vendas;

    public CadastroCliente(String nome, String cpf, String email, String senha, String telefone, Long id, List<Endereco> enderecos) {
        super(nome, cpf, email, senha, telefone);
        this.id = id;
        this.enderecos = enderecos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
