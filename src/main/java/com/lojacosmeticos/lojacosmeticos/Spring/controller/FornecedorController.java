package com.lojacosmeticos.lojacosmeticos.Spring.controller;

import com.lojacosmeticos.lojacosmeticos.Spring.model.Fornecedor;
import com.lojacosmeticos.lojacosmeticos.Spring.model.Funcionario;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.FornecedorRepository;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorRepository forneedorRepository;

    @GetMapping
    public List<Fornecedor> listarFuncionarios() {
        return forneedorRepository.findAll();
    }

    @PostMapping
    public Fornecedor criarFornecedor(@RequestBody Fornecedor fornecedor) {
        return forneedorRepository.save(fornecedor);
    }
    @GetMapping("/deletar/{id}")
    public String deletarFornecedor(@PathVariable Long id) {
        forneedorRepository.deleteById(id);
        return "redirect:/fornecedor/lista-fornecedores";
    }


}
