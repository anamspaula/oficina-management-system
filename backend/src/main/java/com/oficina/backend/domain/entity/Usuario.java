package com.oficina.backend.domain.entity;

import com.oficina.backend.domain.enums.PerfilUsuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PerfilUsuario perfil;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;
}
