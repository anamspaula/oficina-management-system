package com.oficina.backend.dto;

/**
 * DTO de resposta para Veiculo. 
 * Contém os campos que serão retornados ao cliente após a criação ou consulta de um veículo.
 */
public class VeiculoResponseDTO {

    private Long id;
    private Integer ano;
    private String marca;
    private String modelo;
    private String placa;
    private Long usuarioId;


    /**
     * Construtor para criar um VeiculoResponseDTO a partir dos dados do veículo e do ID do usuário.
     * @param id
     * @param ano
     * @param marca
     * @param modelo
     * @param placa
     * @param usuarioId
     */
    public VeiculoResponseDTO(Long id, Integer ano, String marca, String modelo, String placa, Long usuarioId) {
        this.id = id;
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public Integer getAno() {
        return ano;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    

}
