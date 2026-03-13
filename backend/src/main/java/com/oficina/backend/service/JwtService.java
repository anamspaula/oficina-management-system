package com.oficina.backend.service;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * Serviço responsável por gerar tokens JWT para autenticação.
 * Utiliza a biblioteca JJWT para criar tokens seguros com uma chave secreta.
 */
@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    /**
     * Obtém a chave de assinatura para o JWT, convertendo a string secreta em um array de bytes e criando uma chave HMAC SHA.
     * @return Key - a chave de assinatura para o JWT
     */
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    /**
     * Gera um token JWT para o email fornecido. O token inclui o email como assunto, a data de emissão e uma data de expiração.
     * @param email
     * @return String - o token JWT gerado
     */
    public String generateToken(String email) {
        
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration)) // Token válido por 1 hora
                .signWith(getSigningKey())
                .compact();
    }

}
