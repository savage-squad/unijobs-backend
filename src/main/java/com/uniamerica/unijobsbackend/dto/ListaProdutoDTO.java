package com.uniamerica.unijobsbackend.dto;

import lombok.Data;

@Data
public class ListaProdutoDTO {
    private String titulo;
    private String descricao;
    private Double preco;
    private String miniatura;
    private Integer prazo;
}
