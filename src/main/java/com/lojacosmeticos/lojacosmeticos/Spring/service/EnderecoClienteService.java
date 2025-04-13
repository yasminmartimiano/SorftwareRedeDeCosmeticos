package com.lojacosmeticos.lojacosmeticos.Spring.service;

import com.lojacosmeticos.lojacosmeticos.Spring.model.EnderecoCliente;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.EnderecoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoClienteService {
    @Autowired
    private EnderecoClienteRepository enderecoClienteRepository;

    public List<EnderecoCliente> listarTodosEnderecosCliente() {
        return enderecoClienteRepository.findAll();
    }

    public Optional<EnderecoCliente> buscarEnderecoClientePorId(Long id) {
        return enderecoClienteRepository.findById(id);
    }

    public EnderecoCliente criarEnderecoCliente(EnderecoCliente enderecoCliente) {
        if (enderecoCliente.getRua() == null || enderecoCliente.getBairro() == null ||
                enderecoCliente.getCidade() == null || enderecoCliente.getEstado() == null ||
                enderecoCliente.getCep() == null || enderecoCliente.getCliente() == null) {
            throw new IllegalArgumentException("Nenhum campo pode ser nulo.");
        }

        return enderecoClienteRepository.save(enderecoCliente);
    }

    public EnderecoCliente atualizarEnderecoCliente(Long id, EnderecoCliente enderecoClienteAtualizado) {
        Optional<EnderecoCliente> enderecoExistente = enderecoClienteRepository.findById(id);
        if (!enderecoExistente.isPresent()) {
            throw new IllegalArgumentException("Endereço não encontrado.");
        }

        EnderecoCliente enderecoCliente = enderecoExistente.get();

        if (enderecoClienteAtualizado.getRua() == null || enderecoClienteAtualizado.getBairro() == null ||
                enderecoClienteAtualizado.getCidade() == null || enderecoClienteAtualizado.getEstado() == null ||
                enderecoClienteAtualizado.getCep() == null || enderecoClienteAtualizado.getCliente() == null) {
            throw new IllegalArgumentException("Nenhum campo pode ser nulo.");
        }

        enderecoCliente.setRua(enderecoClienteAtualizado.getRua());
        enderecoCliente.setNumero(enderecoClienteAtualizado.getNumero());
        enderecoCliente.setBairro(enderecoClienteAtualizado.getBairro());
        enderecoCliente.setCidade(enderecoClienteAtualizado.getCidade());
        enderecoCliente.setEstado(enderecoClienteAtualizado.getEstado());
        enderecoCliente.setCep(enderecoClienteAtualizado.getCep());
        enderecoCliente.setCliente(enderecoClienteAtualizado.getCliente());

        return enderecoClienteRepository.save(enderecoCliente);
    }

    public void deletarEnderecoCliente(Long id) {
        Optional<EnderecoCliente> enderecoCliente = enderecoClienteRepository.findById(id);

        if (enderecoCliente.isPresent()) {
            enderecoClienteRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Endereço não encontrado.");
        }
    }



}


