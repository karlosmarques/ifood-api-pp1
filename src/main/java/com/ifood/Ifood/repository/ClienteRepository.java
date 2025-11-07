package com.ifood.Ifood.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifood.Ifood.model.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    
} 