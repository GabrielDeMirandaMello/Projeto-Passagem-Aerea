package br.com.passagem.aerea.internal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "passagens")
public class Passagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "passagem")
    @Column
    private List<Voo> voo;


    @Column
    private Enum classePassagem;

    @Column
    private Double valorPassage;

    @ManyToOne
    @JoinColumn(name = "passagem")
    private Carrinho carrinho;
}
