package com.rodrigoramos.cadastroclientes.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeCompleto;
    private String cpf;
    private String sexo;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate dataNascimento;

    private Integer idade;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

}
