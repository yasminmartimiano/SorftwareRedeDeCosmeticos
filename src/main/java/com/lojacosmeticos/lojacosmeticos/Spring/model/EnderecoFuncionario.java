package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "endereco_funcionario")
public class EnderecoFuncionario extends Endereco {
    @OneToOne(mappedBy = "enderecoFuncionario")
    private Funcionario funcionario;

    public EnderecoFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public EnderecoFuncionario(Long id, String rua, String numero, String bairro, String cidade, String estado, String cep, Funcionario funcionario) {
        super(id, rua, numero, bairro, cidade, estado, cep);
        this.funcionario = funcionario;
    }


}

