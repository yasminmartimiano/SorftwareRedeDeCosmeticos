package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.text.SimpleDateFormat;
@Entity
@Table(name = "")
public class Agendamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    final Long id;
    @Column(name = "")
    private SimpleDateFormat dataHora;

    @ManyToOne
    @JoinColumn(name = "")
    private Long idCliente;

    @ManyToOne
    @JoinColumn(name = "")
    private Long idFuncionario;

    @ManyToOne
    @JoinColumn(name = "")
    private Long idServico;

    @Column(name = "")
    private StatusAgendamento statusAgendamento;

    public Agendamentos(Long id, SimpleDateFormat dataHora, @Nonnull Long idCliente, Long idFuncionario, Long idServico, StatusAgendamento statusAgendamento) {
        this.id = id;
        this.dataHora = dataHora;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.idServico = idServico;
        this.statusAgendamento = statusAgendamento;
    }

    public Long getId() {
        return id;
    }

    public SimpleDateFormat getDataHora() {
        return dataHora;
    }

    public void setDataHora(SimpleDateFormat dataHora) {
        this.dataHora = dataHora;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }
}
