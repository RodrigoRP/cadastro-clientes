package com.rodrigoramos.cadastroclientes.mapper;

import com.rodrigoramos.cadastroclientes.dto.ClienteDTO;
import com.rodrigoramos.cadastroclientes.model.Cidade;
import com.rodrigoramos.cadastroclientes.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClienteMapper {

    private final ModelMapper modelMapper;

    public Cliente toModel(ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cidade cidade = new Cidade(null, clienteDTO.getNomeCidade(), clienteDTO.getNomeEstado());
        cliente.setCidade(cidade);

        return cliente;
    }
}

