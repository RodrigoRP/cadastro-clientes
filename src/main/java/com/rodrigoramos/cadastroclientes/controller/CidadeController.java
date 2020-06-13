package com.rodrigoramos.cadastroclientes.controller;

import com.rodrigoramos.cadastroclientes.dto.CidadeDTO;
import com.rodrigoramos.cadastroclientes.model.Cidade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "Cidade API")
public interface CidadeController {

    @ApiOperation("Cadastrar novo cliente")
    ResponseEntity<Cidade> save(@RequestBody CidadeDTO cidadeDTO);

    @ApiOperation("Buscar cliente pelo nome")
    ResponseEntity<Cidade> findByNome(@PathVariable String nome);

    @ApiOperation("Buscar cliente pelo estado")
    ResponseEntity<Cidade> findByEstado(@PathVariable String estado);
}
