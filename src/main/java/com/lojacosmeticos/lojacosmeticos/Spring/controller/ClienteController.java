package com.lojacosmeticos.lojacosmeticos.Spring.controller;

import com.lojacosmeticos.lojacosmeticos.Spring.model.Cliente;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    @GetMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return "redirect:/clientes/lista-clientes";
    }

    @GetMapping("/lista-clientes")
    public String mostrarClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "clientes"; // nome do arquivo HTML (clientes.html)
    }
}
