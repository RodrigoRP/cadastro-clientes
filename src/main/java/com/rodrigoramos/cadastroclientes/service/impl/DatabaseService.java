package com.rodrigoramos.cadastroclientes.service.impl;

import com.rodrigoramos.cadastroclientes.model.Address;
import com.rodrigoramos.cadastroclientes.model.Cliente;
import com.rodrigoramos.cadastroclientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class DatabaseService {

    private final ClienteRepository clienteRepository;

    public void instantiateDatabase() {
        LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);

        Address c1 = new Address(null, "Santa Maria", "RS");
        Address c2 = new Address(null, "Santa Maria", "RS");


        Cliente cl1 = new Cliente(null, "Maria da Silva","123123", "F", birthday, 19, c1);
        Cliente cl2 = new Cliente(null, "Pedro da Silva", "M", "123123", birthday, 89, c2);


        clienteRepository.saveAll(Arrays.asList(cl1, cl2));

    }
}
