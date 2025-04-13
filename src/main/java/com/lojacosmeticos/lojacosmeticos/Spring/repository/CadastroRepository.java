package com.lojacosmeticos.lojacosmeticos.Spring.repository;

import com.lojacosmeticos.lojacosmeticos.Spring.model.Agendamento;
import com.lojacosmeticos.lojacosmeticos.Spring.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro,Long> {
}
