package br.com.passagem.aerea.internal.controller;

import br.com.passagem.aerea.api.controller.PassagemController;
import br.com.passagem.aerea.api.controller.UserController;
import br.com.passagem.aerea.api.usecase.FindAllPassagem;
import br.com.passagem.aerea.internal.entity.Passagem;
import br.com.passagem.aerea.internal.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@ConditionalOnSingleCandidate(PassagemController.class)
public class DefaultPassagemController implements PassagemController{

    private FindAllPassagem findAllPassagem;

    @Override
    public List<Passagem> retrieveAllPassagens() {
        return this.findAllPassagem.execute();
    }
}
