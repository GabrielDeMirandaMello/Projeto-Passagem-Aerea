package br.com.passagem.aerea.internal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.List;

@Entity
@Data
@Table(name="carrinho")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PositiveOrZero
    @Column
    private Long qtdPassagem;

    @PositiveOrZero
    @Column
    private Double valorTotal;

    @OneToMany(mappedBy = "carrinho")
    @Column
    private List<Passagem> passagem;
}
