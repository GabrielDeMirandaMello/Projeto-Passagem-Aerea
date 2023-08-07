package br.com.passagem.aerea.internal.usecase;

import br.com.passagem.aerea.api.usecase.AuthenticatetionUser;
import br.com.passagem.aerea.internal.entity.User;
import br.com.passagem.aerea.internal.exception.InvalidPasswordException;
import br.com.passagem.aerea.internal.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class AuthorizationService implements AuthenticatetionUser {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Override
    public User execute(User user) {
        UserDetails userToAuth = loadUserByUsername(user.getEmail());
        boolean passwordMatches = passwordEncoder.matches(user.getPassword(), userToAuth.getPassword());
        if(passwordMatches){
            User userAuthenticated = (User) userRepository.findByEmail(userToAuth.getUsername());
            return userRepository.save(userAuthenticated);
        }
        throw new InvalidPasswordException(HttpStatus.BAD_REQUEST);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = (User) userRepository.findByEmail(email);

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}
