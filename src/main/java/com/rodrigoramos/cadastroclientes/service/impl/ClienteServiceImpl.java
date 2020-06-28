package com.rodrigoramos.cadastroclientes.service.impl;

import com.rodrigoramos.cadastroclientes.model.Cliente;
import com.rodrigoramos.cadastroclientes.repository.ClienteRepository;
import com.rodrigoramos.cadastroclientes.service.ClienteService;
import com.rodrigoramos.cadastroclientes.service.exceptions.DataIntegrityException;
import com.rodrigoramos.cadastroclientes.service.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    @Override
    public Cliente save(Cliente cliente) {
//        Optional<Cliente> clienteOptional = repository.findClienteByCpf(cliente.getCpf());
//        if (clienteOptional.isPresent()) {
//            throw new ClienteRegistrationException("Cliente com o CPF " + cliente.getCpf() + " já existe");
//        }
        return repository.save(cliente);
    }

    @Override
    public Cliente findById(Long id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    @Override
    public Cliente findByNomeCompleto(String nomeCompleto) {
        Optional<Cliente> cliente = repository.findClienteByNomeCompleto(nomeCompleto);
        return cliente.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado! Nome: " + nomeCompleto + ", Tipo: " + Cliente.class.getName()));
    }

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Cliente findClienteByCpf(String cpf) {
        Optional<Cliente> cliente = repository.findClienteByCpf(cpf);

        return cliente.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado! CPF: " + cpf + ", Tipo: " + Cliente.class.getName()));
    }


}