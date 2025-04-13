package com.lojacosmeticos.lojacosmeticos.Spring.controller;

import com.lojacosmeticos.lojacosmeticos.Spring.model.Cadastro;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {
    @Autowired
    private CadastroRepository cadastroRepository;

    @PostMapping
    public ResponseEntity<Cadastro> criarCadastro(@RequestBody Cadastro cadastro) {
        Cadastro novoCadastro = cadastroRepository.save(cadastro);
        return ResponseEntity.ok(novoCadastro);
    }

    @GetMapping
    public ResponseEntity<List<Cadastro>> listarTodos() {
        List<Cadastro> cadastros = cadastroRepository.findAll();
        return ResponseEntity.ok(cadastros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cadastro> buscarPorId(@PathVariable Long id) {
        return cadastroRepository.findById(id)
                .map(cadastro -> ResponseEntity.ok(cadastro))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cadastro> atualizarCadastro(@PathVariable Long id, @RequestBody Cadastro cadastroAtualizado) {
        return cadastroRepository.findById(id)
                .map(cadastro -> {
                    cadastro.setNome(cadastroAtualizado.getNome());
                    cadastro.setCpf(cadastroAtualizado.getCpf());
                    cadastro.setEmail(cadastroAtualizado.getEmail());
                    cadastro.setSenha(cadastroAtualizado.getSenha());
                    cadastro.setTelefone(cadastroAtualizado.getTelefone());
                    cadastro.setDataNascimento(cadastroAtualizado.getDataNascimento());
                    Cadastro cadastroSalvo = cadastroRepository.save(cadastro);
                    return ResponseEntity.ok(cadastroSalvo);
                }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCadastro(@PathVariable Long id) {
        try {
            return cadastroRepository.findById(id).map(cadastro -> {
                cadastroRepository.delete(cadastro);
                return ResponseEntity.noContent().build();
            }).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
