package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CadastroFuncionario extends Cadastro{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Double salario;
    private Cargos cargo;


    public CadastroFuncionario(String nome, String cpf, String email, String senha, String telefone, Long id, Double salario, Cargos cargo) {
        super(nome, cpf, email, senha, telefone);
        this.id = id;
        this.salario = salario;
        this.cargo = cargo;
    }

    public CadastroFuncionario(String nome, String cpf, String email, String senha, String telefone) {
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
