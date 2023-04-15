package br.com.passagem.aerea.internal.usecase;

import br.com.passagem.aerea.api.usecase.FindAllUser;
import br.com.passagem.aerea.api.usecase.FindUserById;
import br.com.passagem.aerea.internal.entity.User;
import br.com.passagem.aerea.internal.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class DefaultFindUserById implements FindUserById {

    @Autowired
    private UserRepository userController;

    @Override
    public User execute(Long id) {
        return userController.findAllById(id);
    }
}
