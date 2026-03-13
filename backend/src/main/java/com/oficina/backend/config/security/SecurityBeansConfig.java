package com.oficina.backend.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Configuração de beans relacionados à segurança. Este arquivo define os beans necessários para a autenticação e 
 * criptografia de senhas, como o PasswordEncoder.
 */
@Configuration
@EnableWebSecurity
public class SecurityBeansConfig {

    /**
     * Bean para o PasswordEncoder, que é responsável por criptografar as senhas dos usuários.
     * @return PasswordEncoder - o bean de criptografia de senhas
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers( "/auth/**").permitAll()
                .requestMatchers(
                    "/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/swagger-resources/**"
                ).permitAll() // Permitir acesso a endpoints de autenticação
                .anyRequest().permitAll() // Exigir autenticação para outros endpoints
            );

        return http.build();
    }

}
