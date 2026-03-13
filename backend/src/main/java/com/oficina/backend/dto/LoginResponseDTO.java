package com.oficina.backend.dto;

/**
 * DTO para representar os dados de uma resposta de login. 
 * Contém os campos necessários para fornecer informações ao cliente após a autenticação, como token de acesso, 
 * nome do usuário e perfil.
 */
public class LoginResponseDTO {

    private String token;
    private String nome;
    private String Perfil;

    public LoginResponseDTO(String token, String nome, String perfil) {
        this.token = token;
        this.nome = nome;
        Perfil = perfil;
    }

    public String getToken() {
        return token;
    }

    public String getNome() {
        return nome;
    }

    public String getPerfil() {
        return Perfil;
    }

    

}
