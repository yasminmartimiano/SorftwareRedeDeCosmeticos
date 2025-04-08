package com.lojacosmeticos.lojacosmeticos.Spring.model;

import java.util.Date;

public class Cadastro {

    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;
    protected String telefone;
    protected Date dataNascimento;

    public Cadastro(String nome, String cpf, String email, String senha, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }
}
