package br.com.passagem.aerea.internal.usecase;

import br.com.passagem.aerea.api.usecase.CreateUser;
import br.com.passagem.aerea.internal.entity.User;
import br.com.passagem.aerea.internal.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class DefaultCreateUser implements CreateUser  {

    @Autowired
    private UserRepository userController;
    @Override
    @Transactional
    public User execute(User user) {
        return userController.save(user);
    }
}
