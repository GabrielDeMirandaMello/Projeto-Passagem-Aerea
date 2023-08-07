package br.com.passagem.aerea.api.usecase;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticatetionUser extends UserDetailsService {

    br.com.passagem.aerea.internal.entity.User execute(br.com.passagem.aerea.internal.entity.User user);
}
