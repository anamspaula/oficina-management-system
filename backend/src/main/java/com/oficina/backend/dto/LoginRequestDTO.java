package com.oficina.backend.dto;

/**
 * DTO para representar os dados de uma requisição de login. 
 * Contém os campos necessários para autenticação do usuário, como email e senha.
 */
public class LoginRequestDTO {

    private String email;
    private String senha;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
