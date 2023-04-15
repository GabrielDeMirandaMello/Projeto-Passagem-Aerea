package br.com.passagem.aerea.api.usecase;

import br.com.passagem.aerea.internal.entity.User;

import java.util.List;

public interface FindUserById {

    public User execute(Long id);
}
