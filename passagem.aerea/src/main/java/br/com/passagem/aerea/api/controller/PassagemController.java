package br.com.passagem.aerea.api.controller;

import br.com.passagem.aerea.internal.entity.Passagem;
import br.com.passagem.aerea.internal.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/passagens")
public interface PassagemController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Passagem> retrieveAllPassagens();
}
