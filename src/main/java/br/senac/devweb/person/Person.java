package br.senac.devweb.person;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nomeCompleto")
    @NotNull
    @NotEmpty
    private String nomeCompleto;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "fone")
    private String fone;

    @Column(name = "rg")
    private String rg;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "cep")
    private String cep;

}
