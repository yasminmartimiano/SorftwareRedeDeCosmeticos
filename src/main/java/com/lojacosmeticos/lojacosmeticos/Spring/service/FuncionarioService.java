package com.lojacosmeticos.lojacosmeticos.Spring.service;

import com.lojacosmeticos.lojacosmeticos.Spring.model.Funcionario;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Método para salvar um novo funcionário
    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    // Método para listar todos os funcionários
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    // Método para buscar um funcionário por ID
    public Funcionario buscarPorId(Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (funcionario.isPresent()) {
            return funcionario.get();
        } else {
            throw new RuntimeException("Funcionário não encontrado com o id: " + id);
        }
    }

    // Método para atualizar as informações de um funcionário
    public Funcionario atualizar(Long id, Funcionario funcionarioAtualizado) {
        Funcionario funcionarioExistente = buscarPorId(id);
        funcionarioExistente.setNome(funcionarioAtualizado.getNome());
        funcionarioExistente.setCpf(funcionarioAtualizado.getCpf());
        funcionarioExistente.setEmail(funcionarioAtualizado.getEmail());
        funcionarioExistente.setTelefone(funcionarioAtualizado.getTelefone());
        funcionarioExistente.setDataNascimento(funcionarioAtualizado.getDataNascimento());
        funcionarioExistente.setSalario(funcionarioAtualizado.getSalario());
        funcionarioExistente.setCargo(funcionarioAtualizado.getCargo());
        funcionarioExistente.setEnderecoFuncionario(funcionarioAtualizado.getEnderecoFuncionario());

        return funcionarioRepository.save(funcionarioExistente);
    }

    // Método para excluir um funcionário pelo ID
    public void excluir(Long id) {
        funcionarioRepository.deleteById(id);
    }
}

