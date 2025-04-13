package com.lojacosmeticos.lojacosmeticos.Spring.controller;

import com.lojacosmeticos.lojacosmeticos.Spring.model.EnderecoCliente;
import com.lojacosmeticos.lojacosmeticos.Spring.service.EnderecoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco-cliente")
public class EnderecoClienteController {
    @Autowired
    private EnderecoClienteService enderecoClienteService;

    @GetMapping
    public ResponseEntity<List<EnderecoCliente>> listarEnderecosCliente() {
        List<EnderecoCliente> enderecosCliente = enderecoClienteService.listarTodosEnderecosCliente();
        return ResponseEntity.ok(enderecosCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoCliente> buscarEnderecoClientePorId(@PathVariable Long id) {
        Optional<EnderecoCliente> enderecoCliente = enderecoClienteService.buscarEnderecoClientePorId(id);
        if (enderecoCliente.isPresent()) {
            return ResponseEntity.ok(enderecoCliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EnderecoCliente> criarEnderecoCliente(@RequestBody EnderecoCliente enderecoCliente) {
        try {
            EnderecoCliente enderecoClienteCriado = enderecoClienteService.criarEnderecoCliente(enderecoCliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(enderecoClienteCriado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoCliente> atualizarEnderecoCliente(@PathVariable Long id, @RequestBody EnderecoCliente enderecoCliente) {
        try {
            EnderecoCliente enderecoClienteAtualizado = enderecoClienteService.atualizarEnderecoCliente(id, enderecoCliente);
            return ResponseEntity.ok(enderecoClienteAtualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEnderecoCliente(@PathVariable Long id) {
        try {
            enderecoClienteService.deletarEnderecoCliente(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
