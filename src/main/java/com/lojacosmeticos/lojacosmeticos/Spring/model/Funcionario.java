package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cadastro_funcionario")
public class Funcionario extends Cadastro {

    @Column(name = "salario")
    private Double salario;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo")
    private Cargos cargo;

    @OneToOne
    @JoinColumn(name = "endereco_id", nullable = false)
    private EnderecoFuncionario enderecoFuncionario;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<Vendas> vendas = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(Double salario, EnderecoFuncionario enderecoFuncionario, List<Vendas> vendas, Cargos cargo) {
        this.salario = salario;
        this.enderecoFuncionario = enderecoFuncionario;
        this.vendas = vendas;
        this.cargo = cargo;
    }

    public Funcionario(String nome, String cpf, String email, String senha, String telefone, Date dataNascimento, Double salario, EnderecoFuncionario enderecoFuncionario, List<Vendas> vendas, Cargos cargo) {
        super(nome, cpf, email, senha, telefone, dataNascimento);
        this.salario = salario;
        this.enderecoFuncionario = enderecoFuncionario;
        this.vendas = vendas;
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<Vendas> getVendas() {
        return vendas;
    }

    public void setVendas(List<Vendas> vendas) {
        this.vendas = vendas;
    }

    public EnderecoFuncionario getEnderecoFuncionario() {
        return enderecoFuncionario;
    }

    public void setEnderecoFuncionario(EnderecoFuncionario enderecoFuncionario) {
        this.enderecoFuncionario = enderecoFuncionario;
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }
}

