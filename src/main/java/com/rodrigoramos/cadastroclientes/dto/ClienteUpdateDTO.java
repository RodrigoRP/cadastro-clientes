package com.rodrigoramos.cadastroclientes.dto;

import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteUpdateDTO {

    @NotNull
    private JsonNullable<String> nomeCompleto = JsonNullable.undefined();

    protected ClienteUpdateDTO() {
    }

}
