package com.ifood.Ifood.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.xml.crypto.AlgorithmMethod;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ifood.Ifood.model.UsuarioEntity;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(UsuarioEntity usuario){



        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                .withIssuer("ifood-api")
                .withSubject(usuario.getEmail())
                .withExpiresAt(horaExpiracao())
                .sign(algorithm);
                return token;
        } catch(Exception exception){

         return null;
        }
    }


    public String validarToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                .withIssuer("ifood-api")
                .build()
                .verify(token)
                .getSubject();
        } 
        
        catch(Exception exception){
            throw new RuntimeException("Token inválido ou expirado", exception);
        }
    }

    private Instant horaExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
