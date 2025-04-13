package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "venda")
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_venda", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataVenda;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private CadastroCliente cliente;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    @Column(name = "total_venda", nullable = false)
    private Double total;

    public Vendas(Long id, Date dataVenda, CadastroCliente cliente, Funcionario funcionario, Double total) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.total = total;
    }

    public Vendas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public CadastroCliente getCliente() {
        return cliente;
    }

    public void setCliente(CadastroCliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}

