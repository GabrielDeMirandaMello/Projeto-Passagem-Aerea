package br.com.passagem.aerea.internal.repository;

import br.com.passagem.aerea.internal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    User deleteById(Optional<User> user);

    User findAllById(Long id);

}
