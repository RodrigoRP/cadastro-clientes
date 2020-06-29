package com.rodrigoramos.cadastroclientes.mapper;

import com.rodrigoramos.cadastroclientes.dto.CidadeDTO;
import com.rodrigoramos.cadastroclientes.model.Cidade;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CidadeMapper {

    private final ModelMapper modelMapper;

    public Cidade toModel(CidadeDTO cidadeDTO) {
        return modelMapper.map(cidadeDTO, Cidade.class);
    }
}

