package com.rodrigoramos.cadastroclientes.repository;

import com.rodrigoramos.cadastroclientes.model.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

    Optional<Cliente> findClienteByNomeCompleto(String nomeCompleto);

    List<Cliente> findAll();

    Optional<Cliente> findClienteByCpf(String cpf);
}