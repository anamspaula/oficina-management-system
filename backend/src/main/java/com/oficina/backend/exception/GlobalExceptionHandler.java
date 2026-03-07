package com.oficina.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

/**
 * Classe para tratamento global de exceções.
 * Esta classe captura exceções lançadas durante a validação de argumentos e retorna uma resposta adequada ao cliente.
 */
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)

    /**
     * Método para lidar com erros de validação de argumentos. Ele captura as exceções do tipo MethodArgumentNotValidException, 
     * extrai os erros de validação e os retorna em um formato de mapa, 
     * onde a chave é o nome do campo e o valor é a mensagem de erro correspondente.
     * @param ex
     * @return
     */
    public Map<String, String> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach((error) -> 
            errors.put(error.getField(), error.getDefaultMessage())
        );
        
        return errors;
    }

}
