package com.example.CRUD.repository;

import com.example.CRUD.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {

    // Buscar por nome
    List<FuncionarioEntity> findByNomeContainingIgnoreCase(String nome);

    Optional<FuncionarioEntity> findByEmail(String nome);
}
