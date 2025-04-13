package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "cadastro")
@Inheritance(strategy = InheritanceType.JOINED)
public  class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    protected String nome;

    @NotNull
    @Column(name = "cpf", nullable = false, unique = true)
    protected String cpf;

    @NotNull
    @Column(name = "email", nullable = false)
    protected String email;

    @NotNull
    @Column(name = "senha", nullable = false)
    protected String senha;

    @NotNull
    @Column(name = "telefone", nullable = false)
    protected String telefone;

    @NotNull
    @Column(name = "data_nascimento", nullable = false)
    protected Date dataNascimento;

    public Cadastro() {}

    public Cadastro(String nome, String cpf, String email, String senha, String telefone, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

}
