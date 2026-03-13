package com.oficina.backend.domain.repository;

import com.oficina.backend.domain.entity.Veiculo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByUsuarioId(Long usuarioId);

}
