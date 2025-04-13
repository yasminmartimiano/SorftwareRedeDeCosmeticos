package com.lojacosmeticos.lojacosmeticos.Spring.repository;

import com.lojacosmeticos.lojacosmeticos.Spring.model.CadastroCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroClienteRepository  extends JpaRepository<CadastroCliente,Long> {
}
