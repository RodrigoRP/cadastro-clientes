package com.rodrigoramos.cadastroclientes.service;

import com.rodrigoramos.cadastroclientes.model.Cidade;

import java.util.List;

public interface CidadeService {

    Cidade save(Cidade cidade);

    Cidade findById(Long id);

    Cidade findCidadeByNome(String nome);

    List<Cidade> findCidadeByEstado(String estado);

}
