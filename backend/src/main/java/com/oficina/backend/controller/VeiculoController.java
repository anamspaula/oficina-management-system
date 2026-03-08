package com.oficina.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.oficina.backend.domain.entity.Veiculo;
import com.oficina.backend.dto.CreateVeiculoDTO;
import com.oficina.backend.service.VeiculoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")

/**
 * Controlador para gerenciamento de veículos.
 * Este controlador expõe endpoints para criar, listar, buscar por ID e deletar veículos. 
 * Cada veículo está associado a um usuário específico.
 */
public class VeiculoController {

    private final VeiculoService veiculoService;

    /**
     * Construtor para injetar o serviço de veículo.
     * @param veiculoService
     */
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    @Operation(summary = "Criar um novo veículo")
    /**
     *  Endpoint para criar um novo veículo. Recebe um DTO de criação de veículo, 
     * chama o serviço para criar o veículo e retorna o veículo criado.
     * @param dto
     * @return O veículo criado.
     */
    public Veiculo createVeiculo(@RequestBody @Valid CreateVeiculoDTO dto) {
        return veiculoService.createVeiculo(dto);
    }

    @GetMapping
    @Operation(summary = "Obter todos os veículos")
    /**
     * Endpoint para obter todos os veículos. Chama o serviço para obter a lista de veículos e retorna a lista. 
     * @return Uma lista com todos os veículos.
     */
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.getAllVeiculos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter um veículo por ID")
    /**
     * Endpoint para obter um veículo por ID. Chama o serviço para buscar o veículo e retorna o veículo encontrado.
     * @param id
     * @return O veículo encontrado.
     */
    public Veiculo getVeiculoById(@PathVariable Long id) {
        return veiculoService.getVeiculoById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um veículo por ID")
    /**
     * Endpoint para deletar um veículo por ID. Chama o serviço para deletar o veículo.
     * @param id
     */
    public void deleteVeiculo(@PathVariable Long id) {
        veiculoService.deleteVeiculo(id);
    }

}
