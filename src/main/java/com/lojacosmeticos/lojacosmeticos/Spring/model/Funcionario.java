package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Funcionario extends Cadastro{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "")
    private Double salario;
    @Column(name = "")
    private Cargos cargo;

    @OneToMany(mappedBy = "idFuncionario", cascade = CascadeType.ALL)
    List<SaidaEstoque> saidaEstoque;
    @OneToMany(mappedBy = "idFuncionario", cascade = CascadeType.ALL)
    List<Vendas> vendas;


    public Funcionario(String nome, String cpf, String email, String senha, String telefone, Long id, Double salario, Cargos cargo) {
        super(nome, cpf, email, senha, telefone);
        this.id = id;
        this.salario = salario;
        this.cargo = cargo;
    }

    public Funcionario(String nome, String cpf, String email, String senha, String telefone) {
        super(nome, cpf, email, senha, telefone);
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

}
