package br.com.passagem.aerea.api.usecase;

import br.com.passagem.aerea.internal.entity.Passagem;

import java.util.List;

public interface FindAllPassagem {

    public List<Passagem> execute();
}
