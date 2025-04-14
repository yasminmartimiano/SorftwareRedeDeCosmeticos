package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "endereco_funcionario")
public class EnderecoFuncionario extends Endereco {
    @NotNull
    @OneToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    public EnderecoFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public EnderecoFuncionario(Long id, String rua, String numero, String bairro, String cidade, String estado, String cep, Funcionario funcionario) {
        super(id, rua, numero, bairro, cidade, estado, cep);
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}

