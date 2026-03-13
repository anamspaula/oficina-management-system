package com.oficina.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.oficina.backend.domain.entity.Veiculo;
import com.oficina.backend.dto.CreateVeiculoDTO;
import com.oficina.backend.dto.UpdateVeiculoDTO;
import com.oficina.backend.dto.VeiculoResponseDTO;
import com.oficina.backend.service.VeiculoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

/**
 * Controlador para gerenciamento de veículos.
 * Este controlador expõe endpoints para criar, listar, buscar por ID e deletar veículos. 
 * Cada veículo está associado a um usuário específico.
*/
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    /**
     * Construtor para injetar o serviço de veículo.
     * @param veiculoService
     */
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    /**
     *  Endpoint para criar um novo veículo. Recebe um DTO de criação de veículo, 
     * chama o serviço para criar o veículo e retorna o veículo criado.
     * @param dto
     * @return O veículo criado.
    */
    @PostMapping
    @Operation(summary = "Criar um novo veículo")
    public VeiculoResponseDTO createVeiculo(@RequestBody @Valid CreateVeiculoDTO dto) {
        return veiculoService.createVeiculo(dto);
    }

    /**
     * Endpoint para obter todos os veículos. Chama o serviço para obter a lista de veículos e retorna a lista. 
     * @return Uma lista com todos os veículos.
    */
    @GetMapping
    @Operation(summary = "Obter todos os veículos")
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.getAllVeiculos();
    }

    /**
     * Endpoint para obter um veículo por ID. Chama o serviço para buscar o veículo e retorna o veículo encontrado.
     * @param id
     * @return O veículo encontrado.
    */
    @GetMapping("/{id}")
    @Operation(summary = "Obter um veículo por ID")
    public Veiculo getVeiculoById(@PathVariable Long id) {
        return veiculoService.getVeiculoById(id);
    }

    /**
     * Endpoint para deletar um veículo por ID. Chama o serviço para deletar o veículo.
     * @param id
    */
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um veículo por ID")
    public void deleteVeiculo(@PathVariable Long id) {
        veiculoService.deleteVeiculo(id);
    }


    /**
     * Endpoint para atualizar um veículo por ID. Recebe um DTO de atualização de veículo, 
     * chama o serviço para atualizar o veículo e retorna o veículo atualizado.
     * @param id
     * @param dto
     * @return
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um veículo por ID")
    public Veiculo updateVeiculo(@PathVariable Long id, @RequestBody @Valid UpdateVeiculoDTO dto) {
        return veiculoService.updateVeiculo(id, dto);
    }

    /**
     * Endpoint para obter veículos por ID do usuário. 
     * Chama o serviço para buscar os veículos associados ao ID do usuário e retorna a lista de veículos encontrados.
     * @param id
     * @return
     */
    @GetMapping("/usuarios/{id}/veiculos")
    @Operation(summary = "Obter veículos por ID do usuário")
    public List<VeiculoResponseDTO> getVeiculosByUsuarioId(@PathVariable Long id) {
        return veiculoService.getVeiculosByUsuarioId(id);
    }
    

}
