package com.oficina.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/** 
 * DTO para criação de um veículo. Contém os campos necessários para criar um novo veículo no sistema, 
 * incluindo marca, modelo, placa, ano e o ID do usuário proprietário.
 */
public class CreateVeiculoDTO {

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotBlank
    private String placa;

    @NotNull
    private Integer ano;

    @NotNull
    private Long usuarioId;

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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

}
