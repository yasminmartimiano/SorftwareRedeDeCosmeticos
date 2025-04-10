package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  Long id;
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
