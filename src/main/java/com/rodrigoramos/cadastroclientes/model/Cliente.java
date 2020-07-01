package com.rodrigoramos.cadastroclientes.model;

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
    private LocalDate dataNascimento;
    private Integer idade;

    @OneToOne(cascade = CascadeType.ALL)
    private Cidade cidade;

}
