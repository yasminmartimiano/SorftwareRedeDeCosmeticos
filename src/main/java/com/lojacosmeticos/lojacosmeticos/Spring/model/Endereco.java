package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "endereco")
@Inheritance(strategy = InheritanceType.JOINED)
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotNull
    @Column(name = "rua", nullable = false)
    protected String rua;

    @Column(name = "numero")
    protected String numero;

    @NotNull
    @Column(name = "bairro", nullable = false)
    protected String bairro;

    @NotNull
    @Column(name = "cidade", nullable = false)
    protected String cidade;

    @NotNull
    @Column(name = "estado", nullable = false)
    protected String estado;

    @NotNull
    @Column(name = "cep", nullable = false)
    protected String cep;




    public Endereco() {
    }

    public Endereco(Long id, String rua, String numero, String bairro, String cidade, String estado, String cep) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }


}
