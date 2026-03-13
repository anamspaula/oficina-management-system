package com.oficina.backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oficina.backend.domain.entity.Usuario;
import com.oficina.backend.domain.repository.UsuarioRepository;
import com.oficina.backend.dto.LoginRequestDTO;
import com.oficina.backend.dto.LoginResponseDTO;

/**
 * Serviço responsável por autenticar usuários. Ele verifica as credenciais fornecidas, 
 * consulta o banco de dados para encontrar o usuário correspondente e, se a autenticação for bem-sucedida,
 *  gera um token JWT para o usuário.
 */
@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    /**
     * Autentica um usuário com base nas credenciais fornecidas. 
     * Verifica se o email existe no banco de dados e se a senha corresponde à senha armazenada.
     * Se a autenticação for bem-sucedida, gera um token JWT e retorna um DTO com as informações do login.
     * @param dto - objeto contendo o email e a senha do usuário
     * @return LoginResponseDTO - objeto contendo o token JWT, nome do usuário e perfil
     */
    public LoginResponseDTO login(LoginRequestDTO dto) {

        System.out.println("Login Chamado");
       
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }

        String token = jwtService.generateToken(usuario.getEmail());

        return new LoginResponseDTO(token, usuario.getNome(), usuario.getPerfil().name());
    }
    

}
