package com.ifood.Ifood.security;

import java.util.ArrayList;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ifood.Ifood.model.UsuarioEntity;
import com.ifood.Ifood.repository.UsuarioRepository;

@Component
public class CustomUsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity user = this.repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}