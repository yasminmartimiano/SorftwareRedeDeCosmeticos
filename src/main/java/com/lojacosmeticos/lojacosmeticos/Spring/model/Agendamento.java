
package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servicos servico;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_agendamento", nullable = false)
    private StatusAgendamento statusAgendamento;

    public Agendamento(Long id, LocalDateTime dataHora, Funcionario funcionario, Servicos servico, StatusAgendamento statusAgendamento) {
        this.id = id;
        this.dataHora = dataHora;
        this.funcionario = funcionario;
        this.servico = servico;
        this.statusAgendamento = statusAgendamento;
    }


}
