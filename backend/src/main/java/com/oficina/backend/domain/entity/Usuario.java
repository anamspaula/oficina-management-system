package com.oficina.backend.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.oficina.backend.domain.enums.PerfilUsuario;
import jakarta.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private List<Veiculo> veiculos;

    public void setDataCriacao(LocalDateTime now) {
        this.dataCriacao = now;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

}
