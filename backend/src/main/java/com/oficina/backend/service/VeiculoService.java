package com.oficina.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oficina.backend.domain.entity.Usuario;
import com.oficina.backend.domain.entity.Veiculo;
import com.oficina.backend.domain.repository.UsuarioRepository;
import com.oficina.backend.domain.repository.VeiculoRepository;
import com.oficina.backend.dto.CreateVeiculoDTO;

@Service
/**
 * Serviço para gerenciar veículos. Permite criar, listar, buscar por ID e deletar veículos. 
 * Cada veículo está associado a um usuário específico.
 */
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final UsuarioRepository usuarioRepository;

    /**
     * Construtor para injetar as dependências do repositório de veículos e usuários.
     * @param veiculoRepository
     * @param usuarioRepository
     */
    public VeiculoService(VeiculoRepository veiculoRepository, UsuarioRepository usuarioRepository) {
        this.veiculoRepository = veiculoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Método para criar um novo veículo. Recebe um DTO com os dados do veículo e o ID do usuário proprietário.
     * Verifica se o usuário existe e, em seguida, cria e salva o veículo no banco de dados.
     * @param dto
     * @return O veículo criado.
     */
    @SuppressWarnings("null")
    public Veiculo createVeiculo(CreateVeiculoDTO dto) {
        
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(dto.getMarca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setPlaca(dto.getPlaca());
        veiculo.setAno(dto.getAno());
        veiculo.setUsuario(usuario);

        return veiculoRepository.save(veiculo);

    }

    /**
     * Método para obter todos os veículos.
     * @return Uma lista com todos os veículos.
     */
    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    /**
     * Método para obter um veículo por ID. Verifica se o veículo existe e, em caso afirmativo, retorna o veículo.
     * @param id
     * @return
     */
    @SuppressWarnings("null")
    public Veiculo getVeiculoById(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
    }

    /**
     * Método para deletar um veículo por ID. Verifica se o veículo existe e, em caso afirmativo, 
     * deleta o veículo do banco de dados.
     * @param id
     */
    @SuppressWarnings("null")
    public void deleteVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }

}
