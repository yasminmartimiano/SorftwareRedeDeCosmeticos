package com.lojacosmeticos.lojacosmeticos.Spring.controller;

import com.lojacosmeticos.lojacosmeticos.Spring.model.Fornecedor;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.FornecedorRepository;
import com.lojacosmeticos.lojacosmeticos.Spring.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    private FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService){
        this.fornecedorService = fornecedorService;
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor> >listarFuncionarios() {
        return ResponseEntity.status(200).body(fornecedorService.listarFornecedor());
    }

    @PostMapping
    public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor) {
        return ResponseEntity.status(201).body(fornecedorService.cadastrarFornecedor(fornecedor));

    }

    @PutMapping
    public ResponseEntity<Fornecedor> editarFornecedor(@RequestBody Fornecedor fornecedor){
        return ResponseEntity.status(200).body(fornecedorService.editarFornecedor(fornecedor));

    }
   @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirFornecedor (@PathVariable Long id){
       fornecedorService.excluirFornecedor(id);
        return ResponseEntity.status(204).build();
   }





}
