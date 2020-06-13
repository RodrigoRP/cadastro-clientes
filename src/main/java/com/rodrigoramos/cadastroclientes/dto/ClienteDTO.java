package com.rodrigoramos.cadastroclientes.dto;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {

    private String nomeCompleto;
    private String sexo;
    private String cpf;
    private Instant dataNascimento;
    private Integer idade;
    private String cidade;

}