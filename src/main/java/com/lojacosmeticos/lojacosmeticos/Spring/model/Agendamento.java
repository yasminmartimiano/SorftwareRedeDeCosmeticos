
package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private CadastroCliente cliente;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servicos servico;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_agendamento", nullable = false)
    private StatusAgendamento statusAgendamento;

    public Agendamento() {}

    public Agendamento(LocalDateTime dataHora, CadastroCliente cliente, Funcionario funcionario, Servicos servico, StatusAgendamento statusAgendamento) {
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servico = servico;
        this.statusAgendamento = statusAgendamento;
    }

}
