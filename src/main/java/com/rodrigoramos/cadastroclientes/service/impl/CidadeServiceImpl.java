package com.rodrigoramos.cadastroclientes.service.impl;

import com.rodrigoramos.cadastroclientes.model.Cidade;
import com.rodrigoramos.cadastroclientes.repository.CidadeRepository;
import com.rodrigoramos.cadastroclientes.service.CidadeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CidadeServiceImpl implements CidadeService {

    private CidadeRepository cidadeRepository;

    @Override
    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    @Override
    public Cidade findCidadeByNome(String nome) {
        return cidadeRepository.findCidadeByNome(nome);
    }

    @Override
    public Cidade findCidadeByEstado(String estado) {
        return cidadeRepository.findCidadeByEstado(estado);
    }
}
