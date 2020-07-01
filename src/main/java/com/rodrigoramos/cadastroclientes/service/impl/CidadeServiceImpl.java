package com.rodrigoramos.cadastroclientes.service.impl;

import com.rodrigoramos.cadastroclientes.model.Cidade;
import com.rodrigoramos.cadastroclientes.repository.CidadeRepository;
import com.rodrigoramos.cadastroclientes.service.CidadeService;
import com.rodrigoramos.cadastroclientes.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CidadeServiceImpl implements CidadeService {

    private final CidadeRepository cidadeRepository;

    @Override
    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    @Override
    public Cidade findById(Long id) {
        Optional<Cidade> optionalCidade = cidadeRepository.findById(id);
        return optionalCidade.orElseThrow(() -> new ObjectNotFoundException(
                "Cidade não encontrada! Id: " + id + ", Tipo: " + Cidade.class.getName()));
    }

    @Override
    public Cidade findCidadeByNome(String nome) {
        return cidadeRepository.findCidadeByNome(nome);
    }

    @Override
    public List<Cidade> findCidadeByEstado(String estado) {
        return cidadeRepository.findCidadeByEstado(estado);
    }
}
