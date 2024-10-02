package com.example.CRUD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private String categoria;
    private Integer qtdPedido;
    private Double precoUnitario;
    private String fornecedor;
    private String localizacao;
    private LocalDate dataAtualizcao;
    private Integer fkCliente;
}
