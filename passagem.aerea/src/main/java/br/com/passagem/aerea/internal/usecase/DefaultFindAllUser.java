package br.com.passagem.aerea.internal.usecase;

import br.com.passagem.aerea.api.usecase.FindAllUser;
import br.com.passagem.aerea.internal.entity.User;
import br.com.passagem.aerea.internal.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DefaultFindAllUser implements FindAllUser {

    @Autowired
    private UserRepository userController;

    @Override
    public List<User> execute() {
        return userController.findAll();
    }
}
