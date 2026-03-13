package com.oficina.backend.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuração de beans relacionados à segurança. Este arquivo define os beans necessários para a autenticação e 
 * criptografia de senhas, como o PasswordEncoder.
 */
@Configuration
public class SecurityBeansConfig {

    /**
     * Bean para o PasswordEncoder, que é responsável por criptografar as senhas dos usuários.
     * @return PasswordEncoder - o bean de criptografia de senhas
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
