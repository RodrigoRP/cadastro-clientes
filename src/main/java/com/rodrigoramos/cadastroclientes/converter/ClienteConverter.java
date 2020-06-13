package com.rodrigoramos.cadastroclientes.converter;

import com.rodrigoramos.cadastroclientes.dto.ClienteDTO;
import com.rodrigoramos.cadastroclientes.model.Cidade;
import com.rodrigoramos.cadastroclientes.model.Cliente;
import com.rodrigoramos.cadastroclientes.service.CidadeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteConverter {

    private CidadeService cidadeService;

    public Cliente convertToEntity(ClienteDTO clienteDTO) {

        Cidade cidade = cidadeService.findCidadeByNome(clienteDTO.getCidade());

        Cliente cliente = new Cliente();
        cliente.setNomeCompleto(clienteDTO.getNomeCompleto());
        cliente.setDataNascimento(clienteDTO.getDataNascimento());
        cliente.setSexo(clienteDTO.getSexo());
        cliente.setIdade(clienteDTO.getIdade());
        cliente.setCidade(cidade);

        return cliente;
    }
}
