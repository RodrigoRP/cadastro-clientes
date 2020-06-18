package com.rodrigoramos.cadastroclientes.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

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
    private Instant dataNascimento;
    private Integer idade;

    @OneToOne
    private Cidade cidade;

}
