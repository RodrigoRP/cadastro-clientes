package com.rodrigoramos.cadastroclientes.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ClienteDTO {

    private String nomeCompleto;
    private String sexo;
    private String cpf;
    private LocalDate dataNascimento;
    private Integer idade;
    private String nomeCidade;
    private String nomeEstado;

}