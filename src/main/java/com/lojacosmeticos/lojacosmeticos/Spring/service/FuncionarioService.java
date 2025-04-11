package com.lojacosmeticos.lojacosmeticos.Spring.service;

import com.lojacosmeticos.lojacosmeticos.Spring.model.Funcionario;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario cadastrarFuncionario(@RequestBody Funcionario funcionario){
        Optional<Funcionario> existente = funcionarioRepository.findById(funcionario.getId());
        if (existente.isPresent()) {
            throw new RuntimeException("Já existe um funcionário com esse CPF.");
        }
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarFuncionario(){
        List<Funcionario> lista = funcionarioRepository.findAll();
        return lista;
    }
    public Funcionario editarFuncionario(Funcionario funcionario){
        Funcionario funcionarioNovo = funcionarioRepository.save(funcionario);
        return funcionarioNovo;
    }


    public  boolean excluirFuncionario(Long id){
        funcionarioRepository.deleteById(id);
        return  true;

    }

    }

