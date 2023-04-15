package br.com.passagem.aerea.internal.controller;

import br.com.passagem.aerea.api.controller.UserController;
import br.com.passagem.aerea.api.usecase.*;
import br.com.passagem.aerea.internal.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@ConditionalOnSingleCandidate(UserController.class)
public class DefaultUserController implements UserController {

    private CreateUser newCreateUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    private FindAllUser findAllUser;
    private FindUserById findUserById;

    @Override
    public User createUser(User user) {
        return this.newCreateUser.execute(user);
    }

    @Override
    public List<User> retrieveAllUsers() {
        return this.findAllUser.execute();
    }

    @Override
    public User findById(Long id) {
        return this.findUserById.execute(id);
    }

    @Override
    public User updateUser(User user) {
        return this.updateUser.execute(user);
    }

    @Override
    public void deleteUserById(Long id) {
        this.deleteUser.execute(id);
    }
}
