package br.com.passagem.aerea.api.usecase;

import br.com.passagem.aerea.internal.entity.User;

public interface CreateUser {

    public User execute(User user);
}
