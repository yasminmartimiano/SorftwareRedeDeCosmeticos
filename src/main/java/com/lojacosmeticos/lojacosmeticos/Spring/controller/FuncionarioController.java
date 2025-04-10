package com.lojacosmeticos.lojacosmeticos.Spring.controller;

import com.lojacosmeticos.lojacosmeticos.Spring.model.Funcionario;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.FuncionarioRepository;
import com.lojacosmeticos.lojacosmeticos.Spring.service.FornecedorService;
import com.lojacosmeticos.lojacosmeticos.Spring.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    private FuncionarioService funcionarioService;

    public FuncionarioController(FornecedorService fornecedorService){
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>>listarFuncionarios() {
        return ResponseEntity.status(200).body(funcionarioService.listarFuncionario());
    }
    @PostMapping
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario funcionario) {
        return ResponseEntity.status(201).body(funcionarioService.cadastrarFuncionario(funcionario));

    }

    @PutMapping
    public ResponseEntity<Funcionario> editarFuncionario(@RequestBody Funcionario funcionario){
        return ResponseEntity.status(200).body(funcionarioService.editarFuncionario(funcionario));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirFuncionario (@PathVariable Long id){
        funcionarioService.excluirFuncionario(id);
        return ResponseEntity.status(204).build();
    }


}
