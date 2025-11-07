package com.ifood.Ifood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifood.Ifood.dto.LoginDto;
import com.ifood.Ifood.model.UsuarioEntity;
import com.ifood.Ifood.repository.UsuarioRepository;
import com.ifood.Ifood.security.TokenService;
import com.ifood.Ifood.service.AuthService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class authController {


private final AuthService authService;


@PostMapping("/login")
public ResponseEntity login (@RequestBody LoginDto body){
   String token = authService.login(body);
   return ResponseEntity.ok(token);
}


}
