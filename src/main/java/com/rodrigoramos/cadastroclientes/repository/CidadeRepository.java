package com.rodrigoramos.cadastroclientes.repository;

import com.rodrigoramos.cadastroclientes.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    Cidade findCidadeByNome(String nome);

    Cidade findCidadeByEstado(String estado);

}
