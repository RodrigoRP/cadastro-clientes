package com.rodrigoramos.cadastroclientes.service;

import com.rodrigoramos.cadastroclientes.model.Address;

import java.util.List;

public interface CidadeService {

    Address save(Address address);

    Address findById(Long id);

    Address findCidadeByNome(String nome);

    List<Address> findCidadeByEstado(String estado);

}
