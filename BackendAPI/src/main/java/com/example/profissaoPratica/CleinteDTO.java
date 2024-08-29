package com.example.profissaoPratica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CleinteDTO {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String nome;
    private String cpfCnpj;
    private String endereco;
    private String telefone;
    private String email;
    private String dataCadastro;

}
