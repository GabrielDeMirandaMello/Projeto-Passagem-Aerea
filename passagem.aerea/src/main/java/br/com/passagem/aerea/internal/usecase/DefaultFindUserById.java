package br.com.passagem.aerea.internal.usecase;

import br.com.passagem.aerea.api.usecase.FindAllUser;
import br.com.passagem.aerea.api.usecase.FindUserById;
import br.com.passagem.aerea.internal.entity.User;
import br.com.passagem.aerea.internal.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class DefaultFindUserById implements FindUserById {

    @Autowired
    private UserRepository userController;

    @Override
    public User execute(Long id) {
        return userController.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }
}
