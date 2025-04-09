package com.lojacosmeticos.lojacosmeticos.Spring.service;

import com.lojacosmeticos.lojacosmeticos.Spring.model.Produto;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto){
        Produto produtoNovo = produtoRepository.save(produto);
        return produtoNovo;
    }

    public List<Produto> listarProduto(){
        List<Produto> lista = produtoRepository.findAll();
        return lista;
    }
    public Produto editarProduto(Produto produto){
       Produto produtoNovo = produtoRepository.save(produto);
        return produtoNovo;
    }


    public boolean excluirProduto(Long id){
        produtoRepository.deleteById(id);
        return true;

    }

}
