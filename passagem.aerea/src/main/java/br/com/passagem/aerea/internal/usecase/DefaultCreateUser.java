package br.com.passagem.aerea.internal.usecase;

import br.com.passagem.aerea.api.usecase.CreateUser;
import br.com.passagem.aerea.internal.entity.User;
import br.com.passagem.aerea.internal.entity.UserRole;
import br.com.passagem.aerea.internal.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class DefaultCreateUser implements CreateUser {
    private UserRepository userController;
    private PasswordEncoder passwordEncoder;

    @Override
    public User execute(User user) {
        String passwordEncripted = passwordEncoder.encode(user.getPassword());
        user.setSenha(passwordEncripted);
        if (user.getRole() == null){
            user.setRole(UserRole.USER);
        } else {
            user.setRole(UserRole.ADMIN);
        }
        return userController.save(user);
    }
}
