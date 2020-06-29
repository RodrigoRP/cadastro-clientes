package com.rodrigoramos.cadastroclientes.dto;

import lombok.*;

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
    private String cidade;

}