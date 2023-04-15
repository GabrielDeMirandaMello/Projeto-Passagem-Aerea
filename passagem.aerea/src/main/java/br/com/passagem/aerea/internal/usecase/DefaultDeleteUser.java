package br.com.passagem.aerea.internal.usecase;

import br.com.passagem.aerea.api.usecase.DeleteUser;
import br.com.passagem.aerea.internal.entity.User;
import br.com.passagem.aerea.internal.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class DefaultDeleteUser implements DeleteUser {

    @Autowired
    private UserRepository userController;

    @Override
    public void execute(Long id) {
        userController.deleteById(id);
    }
}
