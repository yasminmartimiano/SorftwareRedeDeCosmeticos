package com.lojacosmeticos.lojacosmeticos.Spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nome_cliente")
        private String nomeCliente;
        @Column(name = "itens")
        private String itens;
        @Column(name = "total")
        private Double total;

        public Cliente() {
        }

        public Cliente( String nomeCliente, String itens, Double total) {
                this.nomeCliente = nomeCliente;
                this.itens = itens;
                this.total = total;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {

                this.id = id;
        }

        public String getNomeCliente() {
                return nomeCliente;
        }

        public void setNomeCliente(String nomeCliente) {
                this.nomeCliente = nomeCliente;
        }

        public String getItens() {
                return itens;
        }

        public void setItens(String itens) {
                this.itens = itens;
        }

        public Double getTotal() {
                return total;
        }

        public void setTotal(Double total) {
                this.total = total;
        }




}
