package com.example.CRUD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String nome;
    private String cpfCnpj;
    private String endereco;
    private String telefone;
    private String senha;
    private String email;
    private LocalDate dataCadastro;
    private String funcao;

}
