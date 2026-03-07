package com.oficina.backend.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.oficina.backend.domain.entity.Usuario;
import com.oficina.backend.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(Usuario usuario) {
        // Lógica para criar um novo usuário
        usuario.setDataCriacao(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }
}
