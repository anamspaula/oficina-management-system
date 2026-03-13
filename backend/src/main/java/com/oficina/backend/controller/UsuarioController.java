package com.oficina.backend.controller;

import com.oficina.backend.domain.entity.Veiculo;
import com.oficina.backend.dto.CreateUsuarioDTO;
import com.oficina.backend.dto.UsuarioResponseDTO;
import com.oficina.backend.service.UsuarioService;
import com.oficina.backend.service.VeiculoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gerenciamento de usuários.
 * Este controlador expõe endpoints para criar novos usuários e gerenciar suas informações.
*/
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final VeiculoService veiculoService;

    /**
     * Construtor para injetar o serviço de usuário.
     * @param usuarioService
     */
    public UsuarioController(UsuarioService usuarioService, VeiculoService veiculoService) {
        this.usuarioService = usuarioService;
        this.veiculoService = veiculoService;
    }

    /**
     * Endpoint para criar um novo usuário.
     * Recebe um DTO de criação de usuário, chama o serviço para criar o usuário e retorna um DTO de resposta.
     * @param createUsuarioDTO O DTO contendo as informações para criar um novo usuário.
     * @return Um DTO de resposta contendo as informações do usuário criado.
    */
    @Operation(summary = "Criar um novo usuário")
    @PostMapping
    public UsuarioResponseDTO criarUsuario(@RequestBody @Valid CreateUsuarioDTO createUsuarioDTO) {
        return usuarioService.criarUsuario(createUsuarioDTO);
    }


    /**
     * Endpoint para obter todos os veículos associados a um usuário específico.
     * @param id
     * @return
     */
    @GetMapping("/{id}/veiculos")
    @Operation(summary = "Obter veículos de um usuário específico")
    public List<Veiculo> getUsuariosVeiculos(@PathVariable Long id) {
        return veiculoService.getVeiculosByUsuarioId(id);
    }
    

}
