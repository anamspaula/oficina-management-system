package com.oficina.backend.dto;

import java.time.LocalDateTime;

import com.oficina.backend.domain.enums.PerfilUsuario;

/**
 * DTO para resposta de usuário.
 */
public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private PerfilUsuario perfil;
    private LocalDateTime dataCriacao;


    /**
     * Construtor para criar um DTO de resposta de usuário.
     * @param id
     * @param nome
     * @param email
     * @param perfil
     * @param dataCriacao
     */
    public UsuarioResponseDTO(Long id, String nome, String email, PerfilUsuario perfil, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.perfil = perfil;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

}
