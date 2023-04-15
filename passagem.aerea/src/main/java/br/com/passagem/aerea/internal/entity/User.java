package br.com.passagem.aerea.internal.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;


@Entity
@Data
@Table(name="users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column
    private String nome;

    @NotBlank
    @Column
    private String cpf;

    @NotBlank
    @Column
    private String email;

    @PositiveOrZero
    @Column
    private Integer senha;

    @NotBlank
    @Column
    private String telefone;

    @PositiveOrZero
    @Column
    private Long cartaoCredito;

    @PositiveOrZero
    @Column
    private Long csv;
}
