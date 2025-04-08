package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.Entity;

@Entity
public class CadastroFuncionario extends Cadastro{


    protected String cargo;
    protected Double salario;

    public CadastroFuncionario(String nome, String cpf, String email, String senha, String telefone, String cargo, Double salario) {
        super(nome, cpf, email, senha, telefone);
        this.cargo = cargo;
        this.salario = salario;
    }
}
