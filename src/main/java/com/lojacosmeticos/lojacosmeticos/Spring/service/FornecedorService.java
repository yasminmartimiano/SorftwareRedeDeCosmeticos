package com.lojacosmeticos.lojacosmeticos.Spring.service;

import com.lojacosmeticos.lojacosmeticos.Spring.model.Fornecedor;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> listarFornecedor(){
        List<Fornecedor> lista = fornecedorRepository.findAll();
        return lista;
    }
    public Fornecedor editarFornecedor(Fornecedor fornecedor){
        Fornecedor fornecedorNovo = fornecedorRepository.save(fornecedor);
        return fornecedorNovo;
    }


    public Fornecedor cadastrarFornecedor(Fornecedor fornecedor){
        Fornecedor fornecedorNovo = fornecedorRepository.save(fornecedor);
        return fornecedorNovo;
    }


    public  boolean excluirFornecedor(Long id){
        fornecedorRepository.deleteById(id);
        return  true;

    }
}
