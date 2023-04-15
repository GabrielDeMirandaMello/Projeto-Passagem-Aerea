package br.com.passagem.aerea.internal.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Data
@Table(name = "voo")
public class Voo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column
    private String destino;

    @NotBlank
    @Column
    private String nomeAeroporto;

    @PositiveOrZero
    @Column
    private Double limiteBagagem;

    @PositiveOrZero
    @Column
    private Integer limitePassageiro;

    @NotBlank
    @Column
    private String assento;

    @ManyToOne
    @JoinColumn(name = "voo")
    private Passagem passagem;
}
