package com.lojacosmeticos.lojacosmeticos.Spring.controller;

import com.lojacosmeticos.lojacosmeticos.Spring.model.Estoque;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @GetMapping
    public List<Estoque> listarEstoque() {
        return estoqueRepository.findAll();
    }

    @PostMapping
    public Estoque criarEstoque(@RequestBody Estoque estoque) {
        return estoqueRepository.save(estoque);
    }
    @GetMapping("/deletar/{id}")
    public String deletarproduto(@PathVariable Long id) {
        estoqueRepository.deleteById(id);
        return "redirect:/estoque/lista-estoque";
    }


}
