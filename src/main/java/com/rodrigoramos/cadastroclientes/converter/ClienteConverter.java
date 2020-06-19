package com.rodrigoramos.cadastroclientes.converter;

import com.rodrigoramos.cadastroclientes.dto.ClienteDTO;
import com.rodrigoramos.cadastroclientes.model.Cidade;
import com.rodrigoramos.cadastroclientes.model.Cliente;
import com.rodrigoramos.cadastroclientes.service.CidadeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteConverter {

    private final CidadeService cidadeService;

    public Cliente convertToEntity(ClienteDTO clienteDTO) {
        Cidade cidade = cidadeService.findCidadeByNome(clienteDTO.getCidade());

        return Cliente.builder()
                .nomeCompleto(clienteDTO.getNomeCompleto())
                .idade(clienteDTO.getIdade())
                .sexo(clienteDTO.getSexo())
                .dataNascimento(clienteDTO.getDataNascimento())
                .cpf(clienteDTO.getCpf())
                .cidade(cidade)
                .build();
    }
}
