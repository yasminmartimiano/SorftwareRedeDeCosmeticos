package com.lojacosmeticos.lojacosmeticos.Spring.service;

import com.lojacosmeticos.lojacosmeticos.Spring.exception.ClienteException;
import com.lojacosmeticos.lojacosmeticos.Spring.model.CadastroCliente;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.CadastroClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class CadastroClienteService {
    @Autowired
    private CadastroClienteRepository repository;

    public CadastroCliente salvarCliente(CadastroCliente cliente) {
        try {
            validarCliente(cliente);
            return repository.save(cliente);
        } catch (Exception e) {
            throw new ClienteException("Erro ao salvar cliente: " + e.getMessage());
        }
    }

    public List<CadastroCliente> listarTodos() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new ClienteException("Erro ao listar clientes: " + e.getMessage());
        }
    }

    public CadastroCliente buscarPorId(Long id) {
        try {
            Optional<CadastroCliente> cliente = repository.findById(id);
            return cliente.orElseThrow(() -> new ClienteException("Cliente não encontrado com ID: " + id));
        } catch (Exception e) {
            throw new ClienteException("Erro ao buscar cliente: " + e.getMessage());
        }
    }

    public void deletarCliente(Long id) {
        try {
            if (!repository.existsById(id)) {
                throw new ClienteException("Cliente não encontrado com ID: " + id);
            }
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ClienteException("Erro ao deletar cliente: " + e.getMessage());
        }
    }

    private void validarCliente(CadastroCliente cliente) {
        if (cliente.getSenha().length() != 8) {
            throw new ClienteException("A senha deve conter exatamente 8 caracteres.");
        }

        LocalDate nascimento = cliente.getDataNascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int idade = LocalDate.now().getYear() - nascimento.getYear();
        if (idade < 18) {
            throw new ClienteException("Cliente deve ter pelo menos 18 anos para se cadastrar.");
        }
    }

}
