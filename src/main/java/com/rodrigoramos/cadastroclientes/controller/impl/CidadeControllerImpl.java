package com.rodrigoramos.cadastroclientes.controller.impl;

import com.rodrigoramos.cadastroclientes.controller.CidadeController;
import com.rodrigoramos.cadastroclientes.controller.constants.RestConstants;
import com.rodrigoramos.cadastroclientes.dto.CidadeDTO;
import com.rodrigoramos.cadastroclientes.mapper.CidadeMapper;
import com.rodrigoramos.cadastroclientes.model.Cidade;
import com.rodrigoramos.cadastroclientes.service.CidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_CIDADE)
public class CidadeControllerImpl implements CidadeController {

    private final CidadeService cidadeService;
    private final CidadeMapper mapper;

    @Override
    @PostMapping("/")
    public ResponseEntity<Cidade> save(CidadeDTO cidadeDTO) {
        Cidade cidade = mapper.toModel(cidadeDTO);
        cidade = cidadeService.save(cidade);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cidade.getId()).toUri();

        return ResponseEntity.created(uri).body(cidade);
    }

    @Override
    @GetMapping("/{nome}")
    public ResponseEntity<Cidade> findByNome(@PathVariable("nome") String nome) {
        Cidade cidade = cidadeService.findCidadeByNome(nome);
        return ResponseEntity.ok().body(cidade);
    }

    @Override
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Cidade>> findByEstado(@PathVariable("estado")String estado) {
        List<Cidade> cidade = cidadeService.findCidadeByEstado(estado);
        return ResponseEntity.ok().body(cidade);
    }
}
