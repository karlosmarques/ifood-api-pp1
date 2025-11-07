package com.ifood.Ifood.service;

import org.springframework.stereotype.Service;

import com.ifood.Ifood.dto.LoginDto;
import com.ifood.Ifood.repository.UsuarioRepository;
import com.ifood.Ifood.security.TokenService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final TokenService tokenService;

    private final UsuarioRepository usuarioRepository;

    public String login (LoginDto body){
        var usuario = usuarioRepository.findByEmail(body.email())
        .orElseThrow(()-> new RuntimeException("Usuário ou senha inválidos"));

        if(!usuario.getPassword().equals(body.password())){
            throw new RuntimeException("Usuário ou senha inválidos");
        }

        String token = tokenService.gerarToken(usuario);
        return token;
    }
}
