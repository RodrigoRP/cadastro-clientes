package com.rodrigoramos.cadastroclientes.service;

import com.rodrigoramos.cadastroclientes.model.Cidade;

public interface CidadeService {

    Cidade save(Cidade cidade);

    Cidade findCidadeByNome(String nome);

    Cidade findCidadeByEstado(String estado);
}
