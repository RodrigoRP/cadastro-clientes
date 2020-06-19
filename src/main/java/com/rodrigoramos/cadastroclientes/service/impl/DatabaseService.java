package com.rodrigoramos.cadastroclientes.service.impl;

import com.rodrigoramos.cadastroclientes.model.Cidade;
import com.rodrigoramos.cadastroclientes.model.Cliente;
import com.rodrigoramos.cadastroclientes.repository.CidadeRepository;
import com.rodrigoramos.cadastroclientes.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@AllArgsConstructor
@Service
public class DatabaseService {

    private CidadeRepository cidadeRepository;
    private ClienteRepository clienteRepository;

    public void instantiateDatabase() {
        LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);

        Cidade c1 = new Cidade(null, "Santa Maria", "RS");
        Cidade c2 = new Cidade(null, "Santa Maria", "RS");

        cidadeRepository.saveAll(Arrays.asList(c1, c2));

        Cliente cl1 = new Cliente(null, "Maria da Silva","123123", "F", birthday, 19, c1);
        Cliente cl2 = new Cliente(null, "Pedro da Silva", "M", "123123", birthday, 89, c2);


        clienteRepository.saveAll(Arrays.asList(cl1, cl2));

    }
}
