package com.lojacosmeticos.lojacosmeticos.Spring.config;

import com.lojacosmeticos.lojacosmeticos.Spring.model.Cliente;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {


    @Bean
    CommandLineRunner init(ClienteRepository repository) {
        return args -> {
            Cliente cliente = new Cliente("João da Silva", "Pizza, Refrigerante", 59.90);
            repository.save(cliente);
            Cliente cliente2 = new Cliente("Lívia", "Pizza, Coca Cola", 59.90);
            repository.save(cliente2);


            System.out.println("Cliente salvo com sucesso: " + cliente);
        };
    }
}
