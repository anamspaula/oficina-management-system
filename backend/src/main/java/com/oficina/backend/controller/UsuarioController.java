package com.oficina.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficina.backend.dto.CreateUsuarioDTO;
import com.oficina.backend.dto.UsuarioResponseDTO;
import com.oficina.backend.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")

/**
 * Controlador para gerenciamento de usuários.
 * Este controlador expõe endpoints para criar novos usuários e gerenciar suas informações.
 */
public class UsuarioController {

    private final UsuarioService usuarioService;

    /**
     * Construtor para injetar o serviço de usuário.
     * @param usuarioService
     */
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Operation(summary = "Criar um novo usuário")
    @PostMapping
    /**
     * Endpoint para criar um novo usuário.
     * Recebe um DTO de criação de usuário, chama o serviço para criar o usuário e retorna um DTO de resposta.
     * @param createUsuarioDTO O DTO contendo as informações para criar um novo usuário.
     * @return Um DTO de resposta contendo as informações do usuário criado.
     */
    public UsuarioResponseDTO criarUsuario(@RequestBody @Valid CreateUsuarioDTO createUsuarioDTO) {
        return usuarioService.criarUsuario(createUsuarioDTO);
    }

}
