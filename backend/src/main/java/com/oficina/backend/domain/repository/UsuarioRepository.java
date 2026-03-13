package com.oficina.backend.domain.repository;

import com.oficina.backend.domain.entity.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para a entidade Usuario. Ele estende JpaRepository, o que fornece métodos CRUD básicos para manipulação de dados.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}
