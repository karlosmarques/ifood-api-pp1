package com.ifood.Ifood.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "cliente")
public class ClienteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cliente;

    @Column(nullable = false,length = 100)
    private String nome;

    @Column(nullable = false,length = 50)
    private String cpf;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dt_nascimento;

    @Column(nullable = false,length = 20)
    private String telefone;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario") 
    private UsuarioEntity usuario;



}
