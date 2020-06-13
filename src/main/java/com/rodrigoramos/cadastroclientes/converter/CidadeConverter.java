package com.rodrigoramos.cadastroclientes.converter;

import com.rodrigoramos.cadastroclientes.dto.CidadeDTO;
import com.rodrigoramos.cadastroclientes.model.Cidade;
import org.springframework.stereotype.Service;

@Service
public class CidadeConverter {

    public Cidade convertToEntity(CidadeDTO cidadeDTO) {
        Cidade cidade = new Cidade();
        cidade.setNome(cidadeDTO.getNome());
        cidade.setEstado(cidadeDTO.getEstado());

        return cidade;
    }
}
