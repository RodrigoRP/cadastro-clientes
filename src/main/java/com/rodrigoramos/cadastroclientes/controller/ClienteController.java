package com.rodrigoramos.cadastroclientes.controller;

import com.rodrigoramos.cadastroclientes.dto.ClienteDTO;
import com.rodrigoramos.cadastroclientes.dto.ClienteUpdateDTO;
import com.rodrigoramos.cadastroclientes.model.Cliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Cliente API")
public interface ClienteController {

    @ApiOperation("Add new data")
    ResponseEntity<Cliente> save(@RequestBody ClienteDTO cliente);

    @ApiOperation("Find All")
    ResponseEntity<List<Cliente>> findAll();

    @ApiOperation("Find by Id")
    ResponseEntity<Cliente> findById(@PathVariable Long id);

    @ApiOperation("Find by Nome Completo")
    ResponseEntity<Cliente> findByNomeCompleto(@PathVariable String nomeCompleto);

    @ApiOperation("Delete by id")
    ResponseEntity<Void> deleteClienteById(@PathVariable("id") Long id);

    /*
    @ApiOperation("Find all data")
    public List<ClienteDTO> list();

    @ApiOperation("Pagination request")
    public Page<ClienteDTO> pageQuery(Pageable pageable);
*/

    @ApiOperation("Update one data")
    ResponseEntity<Void> updateCliente(@PathVariable("id") Long id, @RequestBody ClienteUpdateDTO clienteUpdateDTO);
}