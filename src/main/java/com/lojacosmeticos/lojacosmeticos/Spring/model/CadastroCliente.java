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

    public CadastroCliente(String nome, String cpf, String email, String senha, String telefone, Long id, List<Endereco> enderecos) {
        super(nome, cpf, email, senha, telefone);
        this.id = id;
        this.enderecos = enderecos;
    }
}
