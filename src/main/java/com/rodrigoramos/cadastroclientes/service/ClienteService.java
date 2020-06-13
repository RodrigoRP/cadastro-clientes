package com.rodrigoramos.cadastroclientes.service;

import com.rodrigoramos.cadastroclientes.model.Cliente;

public interface ClienteService extends GenericService<Cliente, Long> {

    void deleteById(Long id);

    //Cliente update(Cliente cliente, ClienteUpdateDTO clienteUpdateDTO);
}