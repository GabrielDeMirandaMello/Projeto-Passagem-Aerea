package br.com.passagem.aerea.internal.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Entity
@Data
@Table(name = "passagens")
public class Passagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column
    private String descricao;

    @NotBlank
    @Column
    private String destino;

    @NotBlank
    @Column
    private String nomeAeroporto;

    @PositiveOrZero
    @Column
    private Double limiteBagagem;

    @Column
    private Enum classePassagem;

    @Column
    private Double valorPassagem;

    @NotBlank
    @Column
    private String assento;
}
