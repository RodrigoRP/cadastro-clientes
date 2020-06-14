package com.rodrigoramos.cadastroclientes.repository;

import com.rodrigoramos.cadastroclientes.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    Cidade findCidadeByNome(String nome);

    List<Cidade> findCidadeByEstado(String estado);

}
