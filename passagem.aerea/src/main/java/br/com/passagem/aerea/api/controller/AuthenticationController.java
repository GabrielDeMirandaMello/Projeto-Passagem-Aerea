package br.com.passagem.aerea.api.controller;

import br.com.passagem.aerea.internal.entity.Token;
import br.com.passagem.aerea.internal.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user-auth")
public interface AuthenticationController {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Token retrieveToken(@RequestBody @Valid User user);
}
