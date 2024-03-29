package br.com.passagem.aerea.internal.configuration;

import br.com.passagem.aerea.internal.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@Setter
public class JwtService {

    @Value("${security.jwt.subscription-key}")
    private String subscriptionKey;

    public String generateToken(User user){


        try{
            Algorithm algorithm = Algorithm.HMAC256(subscriptionKey);
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
            return token;
        }
        catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
    }

    public String validateToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(subscriptionKey);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        }
        catch (JWTCreationException exception) {
            return "";
        }
    }
    public Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2L).toInstant(ZoneOffset.of("-03:00"));
    }

}
