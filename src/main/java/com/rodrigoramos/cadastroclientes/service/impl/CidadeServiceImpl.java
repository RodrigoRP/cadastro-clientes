package com.rodrigoramos.cadastroclientes.service.impl;

import com.rodrigoramos.cadastroclientes.model.Address;
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
    public Address save(Address address) {
        return cidadeRepository.save(address);
    }

    @Override
    public Address findById(Long id) {
        Optional<Address> optionalCidade = cidadeRepository.findById(id);
        return optionalCidade.orElseThrow(() -> new ObjectNotFoundException(
                "Cidade não encontrada! Id: " + id + ", Tipo: " + Address.class.getName()));
    }

    @Override
    public Address findCidadeByNome(String nome) {
        return cidadeRepository.findCidadeByNome(nome);
    }

    @Override
    public List<Address> findCidadeByEstado(String estado) {
        return cidadeRepository.findCidadeByEstado(estado);
    }
}
