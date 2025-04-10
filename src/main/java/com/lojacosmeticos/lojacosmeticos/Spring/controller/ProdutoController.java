package com.lojacosmeticos.lojacosmeticos.Spring.controller;

import com.lojacosmeticos.lojacosmeticos.Spring.model.Produto;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @PostMapping
    public Produto criarFornecedor(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
    @GetMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable Long id) {
       produtoRepository.deleteById(id);
        return "redirect:/produtos/lista-produtos";
    }

}
