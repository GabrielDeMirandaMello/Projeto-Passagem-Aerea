package br.com.passagem.aerea.internal.repository;

import br.com.passagem.aerea.internal.entity.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {

}
