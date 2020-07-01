package com.rodrigoramos.cadastroclientes.repository;

import com.rodrigoramos.cadastroclientes.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Address, Long> {

    Address findCidadeByNome(String nome);

    List<Address> findCidadeByEstado(String estado);

}
