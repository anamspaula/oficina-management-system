package com.oficina.backend.service;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oficina.backend.domain.entity.Usuario;
import com.oficina.backend.domain.repository.UsuarioRepository;
import com.oficina.backend.dto.CreateUsuarioDTO;
import com.oficina.backend.dto.UsuarioResponseDTO;

@Service

/**
 * Serviço para gerenciamento de usuários.
 * Este serviço contém a lógica de negócio para criar novos usuários e gerenciar suas informações.
 */
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Construtor para injetar o repositório de usuário.
     * @param usuarioRepository
     */
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * Este método recebe um objeto de usuário, define a data de criação e salva o usuário no banco de dados.
     * @param usuario O objeto de usuário a ser criado.
     * @return O usuário criado com a data de criação definida.
     */
    public Usuario criarUsuario(Usuario usuario) {
        // Lógica para criar um novo usuário
        usuario.setDataCriacao(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    /**
     * Este método recebe um DTO de criação de usuário, converte para a entidade de usuário, 
     * salva no banco de dados e retorna um DTO de resposta.
     * @param dto O DTO contendo as informações para criar um novo usuário.
     * @return Um DTO de resposta contendo as informações do usuário criado.
     */
    public UsuarioResponseDTO criarUsuario(CreateUsuarioDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setPerfil(dto.getPerfil());
        usuario.setDataCriacao(LocalDateTime.now());

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(
            usuarioSalvo.getId(), 
            usuarioSalvo.getNome(), 
            usuarioSalvo.getEmail(), 
            usuarioSalvo.getPerfil(), 
            usuarioSalvo.getDataCriacao()
        );
    }
}
