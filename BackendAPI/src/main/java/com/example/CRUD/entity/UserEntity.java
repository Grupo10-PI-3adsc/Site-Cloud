package com.example.CRUD.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// CRIANDO UMA TABELA
@Entity
@Table(name = "Clientes")
@Getter
@Setter
public class FuncionarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "CPF_CNPJ")
    private String cpfCnpj;

    @Column(name = "Endereco")
    private String endereco;

    @Column(name = "Telefone")
    private String telefone;

    @Column(name = "Email")
    private String email;

    @Column(name = "Senha")
    private String senha;

    @Column(name = "Ativo")
    private Boolean isActive;

    @Column(name = "Data_Cadastro")
    private String dataCadastro;

    @Column(name = "Funcao")
    private String role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}



//package com.example.projeto_03_http_persistencia;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Musica {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String nome;
//    private String artista;
//
//    @Column(name = "anoLancamento")
//    private Integer anoLancamento;
//
//    public Musica() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getArtista() {
//        return artista;
//    }
//
//    public void setArtista(String artista) {
//        this.artista = artista;
//    }
//
//    public Integer getAnoLancamento() {
//        return anoLancamento;
//    }
//
//    public void setAnoLancamento(Integer anoLancamento) {
//        this.anoLancamento = anoLancamento;
//    }
//
//
//}
