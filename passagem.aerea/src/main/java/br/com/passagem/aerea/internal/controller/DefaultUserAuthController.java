package br.com.passagem.aerea.internal.controller;

import br.com.passagem.aerea.api.controller.AuthenticationController;
import br.com.passagem.aerea.api.usecase.AuthenticatetionUser;
import br.com.passagem.aerea.internal.configuration.JwtService;
import br.com.passagem.aerea.internal.entity.Token;
import br.com.passagem.aerea.internal.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@ConditionalOnSingleCandidate(AuthenticationController.class)
public class DefaultUserAuthController implements AuthenticationController {

    private AuthenticatetionUser authenticatetionUser;
    private JwtService jwtService;

    @Override
    public Token retrieveToken(User user) {
        User userFound = this.authenticatetionUser.execute(user);
        String token = jwtService.generateToken(userFound);
        return new Token(token);
    }
}
