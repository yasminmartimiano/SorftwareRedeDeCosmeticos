package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "endereco_cliente")
public class EnderecoCliente extends Endereco {

    @NotNull
    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private CadastroCliente cliente;

    public EnderecoCliente(Long id, String rua, String numero, String bairro, String cidade, String estado, String cep, CadastroCliente cliente, CadastroCliente cliente1) {
        super(id, rua, numero, bairro, cidade, estado, cep, cliente);
        this.cliente = cliente1;
    }

    public CadastroCliente getCliente() {
        return cliente;
    }

    public void setCliente(CadastroCliente cliente) {
        this.cliente = cliente;
    }
}

