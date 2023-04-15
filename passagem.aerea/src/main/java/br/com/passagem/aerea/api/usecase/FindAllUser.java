package br.com.passagem.aerea.api.usecase;

import br.com.passagem.aerea.internal.entity.User;

import java.util.List;

public interface FindAllUser {

    public List<User> execute();
}
