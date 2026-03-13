package com.oficina.backend.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * Serviço responsável por gerar tokens JWT para autenticação.
 * Utiliza a biblioteca JJWT para criar tokens seguros com uma chave secreta.
 */
@Service
public class JwtService {

    private final String SECRET_KEY = "chave-secreta-super-segura";

    /**
     * Gera um token JWT para o email fornecido. O token inclui o email como assunto, a data de emissão e uma data de expiração.
     * @param email
     * @return String - o token JWT gerado
     */
    public String generateToken(String email) {
        
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 3600000)) // Token válido por 1 hora
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .compact();
    }

}
