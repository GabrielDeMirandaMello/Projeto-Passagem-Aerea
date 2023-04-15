package br.com.passagem.aerea.internal.usecase;

import br.com.passagem.aerea.api.usecase.UpdateUser;
import br.com.passagem.aerea.internal.entity.User;
import br.com.passagem.aerea.internal.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class DefaultUpdateUser implements UpdateUser {

    @Autowired
    private UserRepository userController;

    @Override
    public User execute(User user) {
        return userController.save(user);
    }
}
