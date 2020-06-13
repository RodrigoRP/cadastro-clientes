package com.rodrigoramos.cadastroclientes.service.impl;

import com.rodrigoramos.cadastroclientes.model.Cidade;
import com.rodrigoramos.cadastroclientes.model.Cliente;
import com.rodrigoramos.cadastroclientes.repository.CidadeRepository;
import com.rodrigoramos.cadastroclientes.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;

@AllArgsConstructor
@Service
public class DatabaseService {

    private CidadeRepository cidadeRepository;
    private ClienteRepository clienteRepository;

    public void instantiateDatabase() {
        Cidade c1 = new Cidade(null, "Santa Maria", "RS");
        Cidade c2 = new Cidade(null, "Santa Maria", "RS");

        cidadeRepository.saveAll(Arrays.asList(c1, c2));

        Instant instant = Instant.now();
        Cliente cl1 = new Cliente(null, "Maria da Silva", "F", instant, 19, c1);
        Cliente cl2 = new Cliente(null, "Pedro da Silva", "M", instant, 89, c2);


        clienteRepository.saveAll(Arrays.asList(cl1, cl2));

    }
}
