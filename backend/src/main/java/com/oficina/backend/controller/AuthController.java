package com.oficina.backend.controller;

import org.springframework.web.bind.annotation.*;

import com.oficina.backend.dto.LoginRequestDTO;
import com.oficina.backend.dto.LoginResponseDTO;
import com.oficina.backend.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * Controlador responsável por lidar com as requisições de autenticação, como login e logout.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Endpoint para realizar o login do usuário. Recebe as credenciais de login e retorna um token de autenticação.
     * @param dto Objeto contendo as credenciais de login (email e senha).
     * @return Objeto contendo o token de autenticação e informações do usuário.
     */
    @PostMapping("/login")
    @Operation(summary = "Realizar login do usuário")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO dto) {
        return authService.login(dto);
    }

}
