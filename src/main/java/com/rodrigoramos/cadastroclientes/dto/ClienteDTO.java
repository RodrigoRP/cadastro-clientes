package com.rodrigoramos.cadastroclientes.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private String nomeCompleto;
    private String sexo;
    private String cpf;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate dataNascimento;
    private Integer idade;
    private AddressDTO address;

}