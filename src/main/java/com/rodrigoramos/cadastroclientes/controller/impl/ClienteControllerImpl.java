package com.rodrigoramos.cadastroclientes.controller.impl;

import com.rodrigoramos.cadastroclientes.controller.ClienteController;
import com.rodrigoramos.cadastroclientes.controller.constants.RestConstants;
import com.rodrigoramos.cadastroclientes.dto.ClienteDTO;
import com.rodrigoramos.cadastroclientes.dto.ClienteUpdateDTO;
import com.rodrigoramos.cadastroclientes.event.CreateResourceEvent;
import com.rodrigoramos.cadastroclientes.mapper.ClienteMapper;
import com.rodrigoramos.cadastroclientes.model.Cliente;
import com.rodrigoramos.cadastroclientes.service.ClienteService;
import com.rodrigoramos.cadastroclientes.utils.JsonNullableUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_CLIENTE)
public class ClienteControllerImpl implements ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper mapper;
    private final ApplicationEventPublisher publisher;

    @Override
    @PostMapping("/")
    public ResponseEntity<Cliente> save(@RequestBody ClienteDTO clienteDTO, HttpServletResponse response) {
        Cliente cliente = mapper.toModel(clienteDTO);
        cliente = clienteService.save(cliente);
        publisher.publishEvent(new CreateResourceEvent(this, response, cliente.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clienteList = clienteService.findAll();
        return ResponseEntity.ok().body(clienteList);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok().body(cliente);
    }

    @Override
    @GetMapping("/nome/{nomeCompleto}")
    public ResponseEntity<Cliente> findByNomeCompleto(@PathVariable("nomeCompleto") String nomeCompleto) {
        Cliente cliente = clienteService.findByNomeCompleto(nomeCompleto);
        return ResponseEntity.ok().body(cliente);
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateCliente(@PathVariable("id") Long id,
                                              @RequestBody ClienteUpdateDTO clienteUpdateDTO) {

        Cliente cliente = clienteService.findById(id);
        JsonNullableUtils.changeIfPresent(clienteUpdateDTO.getNomeCompleto(), cliente::setNomeCompleto);
        clienteService.save(cliente);

        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClienteById(@PathVariable Long id) {
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

