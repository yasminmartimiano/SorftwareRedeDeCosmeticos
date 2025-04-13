package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cadastro_cliente")
public class CadastroCliente extends Cadastro {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", nullable = false)
    private EnderecoCliente enderecoCliente;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Agendamento> agendamentos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Vendas> vendas;

    public CadastroCliente() {}

    public CadastroCliente(String nome, String cpf, String email, String senha, String telefone, Date dataNascimento, EnderecoCliente enderecoCliente) {
        super(nome, cpf, email, senha, telefone, dataNascimento);
        this.enderecoCliente = enderecoCliente;
    }

}

