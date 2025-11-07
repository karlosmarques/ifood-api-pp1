package com.ifood.Ifood.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifood.Ifood.model.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByEmail(String email);
}