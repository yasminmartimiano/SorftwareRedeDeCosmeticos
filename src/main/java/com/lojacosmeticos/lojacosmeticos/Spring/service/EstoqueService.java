package com.lojacosmeticos.lojacosmeticos.Spring.service;

import com.lojacosmeticos.lojacosmeticos.Spring.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {
    private EstoqueRepository repository;

    public EstoqueService(EstoqueRepository repository) {
        this.repository = repository;
    }


}
