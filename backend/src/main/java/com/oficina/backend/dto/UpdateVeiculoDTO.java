package com.oficina.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO para atualização de veículo. Contém os campos necessários para atualizar as informações de um veículo existente.
 * Todos os campos são obrigatórios e validados para garantir que as informações sejam consistentes.
 */
public class UpdateVeiculoDTO {

   @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotBlank
    private String placa;

    @NotNull
    private Integer ano;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    

}
